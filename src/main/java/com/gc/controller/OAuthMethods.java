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

    public static String getOAuthToken(String code){
        //TODO always delete before a push
        String clientId = "223829578051.223904316370";
        String clientSecret = "a9463fab81cf05d0b25722e2511a85c6";
        String accessToken = "";
        try {
            URL url = new URL("https://slack.com/api/oauth.access?client_id="+clientId+"&client_secret="+clientSecret+"&code="+code);
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

} //add temp page as redirect uri
