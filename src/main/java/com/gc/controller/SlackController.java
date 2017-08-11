package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String privatemessage(@CookieValue("cookieToken") String cookieToken, @RequestParam("slackmessage") String message, @RequestParam("channel") String channel) {
        OAuthMethods.sendPrivateMessage(message, cookieToken, channel);
        return "slackmessagesuccess";
    }
}
