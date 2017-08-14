package com.gc.controller;

import com.gc.dao.LanguagesDAO;
import com.gc.factory.DaoFactory;
import com.gc.models.LanguagesEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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
    public ModelAndView login2(HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        String cookienamestring = "";
        for (int i = 0; i < cookie.length; i++) {
            Cookie cookiename = cookie[i];
            cookienamestring = cookiename.getName();
            if (cookienamestring.equals("userIdCookie")) {
                LanguagesDAO languagesDAO = DaoFactory.getLanguagesDaoInstance(DaoFactory.LANGUAGES_HIBERNATE_DAO);
                ArrayList<LanguagesEntity> languageList = languagesDAO.getAllLanguages();
                return new
                        ModelAndView("home", "lList", languageList);
            }
        }

        return new ModelAndView("login","","");
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
