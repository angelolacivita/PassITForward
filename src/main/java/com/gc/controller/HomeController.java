package com.gc.controller;

import com.gc.models.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by angelo on 8/7/17.
 */


@Controller
public class HomeController {

    @RequestMapping("/")
    //the String method returns the jsp page that we want to show
    public String welcome() {

        return "welcome";
    }

    @RequestMapping("/home")
    //the String method returns the jsp page that we want to show
    public String home() {

        return "home";
    }

    @RequestMapping("/about")
    //the String method returns the jsp page that we want to show
    public String about() {

        return "about";
    }

    @RequestMapping("/challenges")
    //the String method returns the jsp page that we want to show
    public String challenges() {

        return "challenges";
    }

    @RequestMapping("/contact")
    //the String method returns the jsp page that we want to show
    public String contact() {

        return "contact";
    }

    @RequestMapping("/newcomment")
    //the String method returns the jsp page that we want to show
    public String newcomment() {

        return "newcomment";
    }

    @RequestMapping("/loginsuccess")
    //the String method returns the jsp page that we want to show
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);

        return "loginsucess";
    }

    @RequestMapping("/create-profile")
    //the String method returns the jsp page that we want to show
    public String registration(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                               Model model) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();
        UsersEntity newUser = new UsersEntity();

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPassword(password);
        newUser.setEmail(email);

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("password", password);
        model.addAttribute("email", email);

        return "registrationsuccess";
    }

    @RequestMapping("/registration")
    //the String method returns the jsp page that we want to show
    public String registration() {

        return "registration";
    }

    @RequestMapping("/projectselect")
    //the String method returns the jsp page that we want to show
    public String projectselect() {
        return "projectselect";
    }

    @RequestMapping("/languages-select")
    //the String method returns the jsp page that we want to show
    public String languageselect() {
        return "languageselect";
    }


    @RequestMapping("/newComment")

    public String newComment() {
        return "newComment";
    }
}