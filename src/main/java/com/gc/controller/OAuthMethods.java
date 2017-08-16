package com.gc.controller;

import com.gc.util.Secrets;
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
    /**
     * This method gets the unique access token for the slack login. It sorts through the
     * json object to extract the access token using the slack api oauth.access method.
     * @param code - we get this temporary code from the url of the page redirected to after authorizing
     *             slack login permissions. This slack api is redirected to the temp page where we extract the code from
     *             the url and pass it into this method
     * @return - this method returns the access token that is unique to every user of the site.
     *              It is used for every single slack api method going forward.
     */
    public static String getOAuthToken(String code) {
        //TODO always delete before a push
        Secrets secret = new Secrets();
        String clientId = secret.getClientId();
        String clientSecret = secret.getClientSecret();
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

    /**
     * @param token - this is the access token received from the previous method (getOAuthToken).
     * @return - This method returns the userId from the users.identity slack api method.
     *           It extracts the json object "id" from the object "user". We use this user Id
     *           in the method to send a private message.
     */
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
            //System.out.println("We made it this far at least");
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



    /**
     * This method finds the username of the person who the user wants to message and converts that
     * to a userId code that can be used in the privatemessage method to actually generate the code.
     * The method takes the users input for username, and tries to match the username to all the names included in the
     * team (found from users.list slack api method). If and once the name is found, userId corresponding to
     * that name (found on the json object) is extracted and returned.
     * @param token - this is the access token received from the previous method (getOAuthToken).
     * @param userNameChannel - this is the username of the person the user wants to directly
     *                        message on slack. This is passed in from when the user inputs the
     *                        username on the slackmessage.jsp.
     * @return - returning the channel id (converting from the actual username - ex: @fhanif - to
     *           code of letters and numbers from the json object obtained using the users.list method.
     */
    public static String getChannelId2(String token, String userNameChannel) {
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
            System.out.println(json);


            JSONArray jsonArray = json.getJSONArray("members");
            //String name = jsonArray.getJSONObject(0).get("name").toString();
            //System.out.println(name);

            for (int i = 0; i < jsonArray.length(); i++) {
                if (jsonArray.getJSONObject(i).get("name").toString().equalsIgnoreCase(userNameChannel)) {
                    channelId = jsonArray.getJSONObject(i).get("id").toString();
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

    /**
     * @param token - this is the access token received from the previous method (getOAuthToken).
     * @param slackmessage - this is the message that is passed in as a parameter from what the
     *
     * @param channel
     * @param userId
     */
    public static void sendPrivateMessage(String token, String slackmessage, String channel, String userId) {


        try {
            URL url = new URL("https://slack.com/api/chat.postMessage?token=" + token +
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