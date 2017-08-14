package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
//@RequestMapping("link")
public class StringMappings {

    @RequestMapping("/") // returns the login page
    //the String method returns the jsp page that we want to show
    public String login2() {

        return "login";
    }

    @RequestMapping("/about") // needs copy
    //the String method returns the jsp page that we want to show
    public String about() {
        return "about";
    }

    @RequestMapping("/contact")
    //the String method returns the jsp page that we want to show
    public String contact() {
        return "contact";
    }

    @RequestMapping("/submitslackmessage")
    public String submitslackmessage() {

        return "slackmessage";
    }

    @RequestMapping("/tempPage")
    public String tempPage() {

        return "tempPage";
    }

    @RequestMapping("/registrationsuccess")
    //the String method returns the jsp page that we want to show
    public String registrationsuccess() {
        return "registrationsuccess";
    }

    @RequestMapping("/logintest") // returns the login page
    //the String method returns the jsp page that we want to show
    public String logintest() {

        return "loginTEST";
    }

}
