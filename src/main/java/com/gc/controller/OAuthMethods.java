package com.gc.controller;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fhani on 8/8/2017.
 */
public class OAuthMethods {

    public static String getOAuthToken(String code) {
        //TODO always delete before a push
        String clientId = "223829578051.223904316370";
        String clientSecret = "a9463fab81cf05d0b25722e2511a85c6";
        String accessToken = "";
        try {
            URL url = new URL("https://slack.com/api/oauth.access?client_id=" + clientId + "&client_secret=" + clientSecret + "&code=" + code);
            BufferedReader reader;
            String jsonStr = "";
            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            for (String line; (line = reader.readLine()) != null; ) {
                jsonStr += line;
            }
            JSONObject json = new JSONObject(jsonStr);
            accessToken = json.getString("access_token");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return accessToken;
    }

    public static String getUserID(String token) {
        //String token = "cookieToken";
        String userID = "";
        try {
            URL url = new URL("https://slack.com/api/users.identity?token=" + token);

            BufferedReader reader;
            String jsonStr = "";
            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            for (String line; (line = reader.readLine()) != null; ) {
                jsonStr += line;
            }
            System.out.println("We made it this far at least");
            JSONObject json = new JSONObject(jsonStr);
            userID = json.getJSONObject("user").get("id").toString();

            System.out.println(userID);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userID;
    }


    public static void sendPrivateMessage(String slackmessage, String token,String channel) {
        //String channel = "mattmenna";
//        String token = "cookieToken";
        //String slackmessage = "this is a test for private message";
        String asUser = getUserID(token);

        try {
            URL url = new URL("https://slack.com/api/chat.postMessage?token=" + token+
                    "channel=40%" + channel + "&text=" + slackmessage + "as_user=" + asUser);

            System.out.println(url);
            BufferedReader reader;
            String jsonStr = "";

            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            for (String line; (line = reader.readLine()) != null; ) {
                jsonStr += line;
            }
            JSONObject json = new JSONObject(jsonStr);
            slackmessage = json.getJSONObject("message").getString("text");
            System.out.println(slackmessage);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}