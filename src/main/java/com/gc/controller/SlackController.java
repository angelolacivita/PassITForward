package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * (Alphabetical Order)
 * <p>
 * Farha Hanif
 * https://github.com/fhanif
 * <p>
 * Angelo LaCivita
 * https://github.com/angelolacivita
 * <p>
 * Matthew Menna
 * https://github.com/mattmenna
 * https://www.linkedin.com/in/matthew-menna/
 */


@Controller
public class SlackController {
    @RequestMapping(value = "/slackmessagesuccess", method = RequestMethod.GET)
    public String privatemessage(@CookieValue("cookieToken") String cookieToken, @RequestParam("slackmessage") String message, @RequestParam("channel") String privateChannel, HttpServletResponse response) {

        String userId = OAuthMethods.getUserID(cookieToken);
        privateChannel = OAuthMethods.getChannelId2(cookieToken, privateChannel);
        response.addCookie(new Cookie("cookieChannelId", privateChannel));
        response.addCookie(new Cookie("cookieUserId", userId));
        OAuthMethods.sendPrivateMessage(cookieToken, message,privateChannel,userId);
        return "slackmsgsuccess";
    }



    @RequestMapping(value ="/loginSlack", method=RequestMethod.GET)
    //the String method returns the jsp page that we want to show
    //also redirects to the home page after login in with slack
    public String loginSlack(Model model, @RequestParam("tempCode") String code, HttpServletResponse response) {

        String accessToken = OAuthMethods.getOAuthToken(code);
        response.addCookie(new Cookie("cookieToken", accessToken));
        model.addAttribute("token", accessToken);

        return "home";
    }
}
