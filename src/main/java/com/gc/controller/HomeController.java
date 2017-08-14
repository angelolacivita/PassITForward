package com.gc.controller;

import com.gc.dao.*;
import com.gc.factory.DaoFactory;
import com.gc.models.*;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class HomeController {

    private UsersEntity loggedInUser;

    @RequestMapping("/home") // this page shows the challenges for each language
    //the String method returns the jsp page that we want to show
    //also redirects to the home page after loggin in with slack
    public ModelAndView home(Model model, HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        String cookienamestring="";
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
        return new ModelAndView("login", "", "");
    }


    @RequestMapping(value = "/login")
    public String login(Model model) {

        model.addAttribute("button", "Sign in with Slack");
        model.addAttribute("isLogin", false);
        model.addAttribute("msg", message);
        return "login";
    }


    private UsersEntity loginUser;

    private String message;

    @RequestMapping(value = "/loginUser")
    public String loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (validUserAndPass(userName, password) != null) {
            loginUser = validUserAndPass(userName, password);
            int userId = loginUser.getUserId();
            Cookie userCookie = new Cookie("userIdCookie", (Integer.toString(userId)));
            userCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(userCookie);
            return "loginsuccess";
        } else {
            message = "Incorrect username or password";
            return "redirect:login";
        }
    }

    private UsersEntity validUserAndPass(String userName, String password) {
        UserDAO userDAO = DaoFactory.getUserDaoInstance(DaoFactory.USERS_HIBERNATE_DAO);

        return userDAO.getUser(userName, password);
    }

    @RequestMapping("/loginsuccess")
    //the String method returns the jsp page that we want to show
    public String loginsuccess() {

        return "loginsuccess";
        //if else statement
    }


    @RequestMapping("/registration")
    //the String method returns the jsp page that we want to show
    public ModelAndView registration(Model model) {

        return new ModelAndView("registration", "command", new UsersEntity());
    }

    @RequestMapping("/create-profile")
    public String registration(@ModelAttribute UsersEntity newUser, Model model) {
        UserDAO userdao = DaoFactory.getUserDaoInstance(DaoFactory.USERS_HIBERNATE_DAO);

        Integer userIDforWallet = userdao.save(newUser);

        WalletEntity newWallet = new WalletEntity();

        WalletDAO walletDAO = DaoFactory.getWalletDaoInstance(DaoFactory.WALLET_HIBERNATE_DAO);

        newWallet.setWalletValue(10);
        newWallet.setUserId(userIDforWallet);
        walletDAO.save(newWallet);

        model.addAttribute("firstName", newUser.getFirstName());
        model.addAttribute("walletValue", newWallet.getWalletValue());

        return "registrationsuccess";
    }


    @RequestMapping("/loginUserTEST")
    //the String method returns the jsp page that we want to show
    public String loginUserTEST(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model) {


        model.addAttribute("username", username);
        model.addAttribute("password", password);

        return "loginsuccess";
        //if else statement
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie userCookie = new Cookie("userIdCookie", "");
        userCookie.setMaxAge(0);
        response.addCookie(userCookie);
        Cookie userCookie2 = new Cookie("cookieToken", "");
        userCookie2.setMaxAge(0);
        response.addCookie(userCookie2);
        return "logout";
    }

    @RequestMapping("/pleaselogin")
    public String pleaselogin() {
        return "pleaselogin";
    }

}