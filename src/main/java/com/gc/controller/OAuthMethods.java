package com.gc.controller;

import org.json.JSONArray;
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

//    public static String getChannelId (String token) {
//        String channelId = "";
//
//        try {
//            URL url = new URL("https://slack.com/api/im.list?token=" + token);
//
//            BufferedReader reader;
//            String jsonStr = "";
//            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//
//            for (String line; (line = reader.readLine()) != null; ) {
//                jsonStr += line;
//            }
//            //System.out.println("We made it this far at least");
//            JSONObject json = new JSONObject(jsonStr);
//            channelId = json.getJSONObject("ims").get("id").toString();
//
//            System.out.println(channelId);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return channelId;
//    }

    public static String getChannelId2 (String token, String userNameChannel) {
        String channelId = "";


        try {
            URL url = new URL("https://slack.com/api/users.list?token=" + token);

            BufferedReader reader;
            String jsonStr = "";
            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            for (String line; (line = reader.readLine()) != null; ) {
                jsonStr += line;
            }
            //System.out.println("We made it this far at least 2");
            JSONObject json = new JSONObject(jsonStr);
            //System.out.println(json);




            JSONArray jsonArray = json.getJSONArray("members");
            String name = jsonArray.getJSONObject(0).get("name").toString();
            System.out.println(name);

            for (int i = 0; i < jsonArray.length(); i++) {
                if (jsonArray.getJSONObject(i).get("name").toString().equalsIgnoreCase(userNameChannel)) {
                    channelId = jsonArray.getJSONObject(i).get("id").toString();
                   // break;
                }
            }


            System.out.println(channelId);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return channelId;
    }


    public static void sendPrivateMessage(String token,String slackmessage, String channel, String userId) {


        try {
            URL url = new URL("https://slack.com/api/chat.postMessage?token=" + token+
                    "&channel=" + channel + "&text=" + slackmessage + "&as_user=" + userId);
            url.openStream();




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}