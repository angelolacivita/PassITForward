package com.gc.controller;

import com.gc.dao.*;
import com.gc.factory.DaoFactory;
import com.gc.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public ModelAndView home(Model model, HttpServletResponse response) {
        LanguagesDAO languagesDAO = DaoFactory.getLanguagesDaoInstance(DaoFactory.LANGUAGES_HIBERNATE_DAO);

        ArrayList<LanguagesEntity> languageList = languagesDAO.getAllLanguages();

        return new
                ModelAndView("home", "lList", languageList);
    }

    @RequestMapping("/loginsuccess")
    //the String method returns the jsp page that we want to show
    public String loginsuccess(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {


        model.addAttribute("username", username);
        model.addAttribute("password", password);

        return "loginsuccess";
        //if else statement
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login", "command", new UsersEntity());
    }


    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(UsersEntity user, Model model) {

        //System.out.println(user);
        user.setPassword(user.getPassword());
        loggedInUser = UserDAOImpl.getUser(user.getUserName(), user.getPassword());
        return new ModelAndView("loginsuccess", "command", loggedInUser);
    }

    @RequestMapping("/registration")
    //the String method returns the jsp page that we want to show
    public ModelAndView registration(Model model) {

        return new ModelAndView("registration", "command", new UsersEntity());
    }

    @RequestMapping("/create-profile")
    public String registration(@ModelAttribute UsersEntity newUser, Model model){
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

}