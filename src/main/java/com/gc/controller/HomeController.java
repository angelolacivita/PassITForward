package com.gc.controller;

import com.gc.models.CommentsEntity;
import com.gc.models.LanguagesEntity;
import com.gc.models.PostsEntity;
import com.gc.models.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * (Alphabetica Order)
 *
 * Farha Hanif
 * https://github.com/fhanif
 *
 * Angelo LaCivita
 * https://github.com/angelolacivita
 *
 * Matthew Menna
 * https://github.com/mattmenna
 * https://www.linkedin.com/in/matthew-menna/
 */


@Controller
public class HomeController {

    private Session getSession() {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();
        session.beginTransaction();
        return session;

    }
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
    public String loginsuccess(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);

        return "loginsucess";
    }

    @RequestMapping("/login")
    //the String method returns the jsp page that we want to show
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);

        return "login";
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

    @RequestMapping("/newComment")

    public String newComment() {
        return "newComment";
    }

    @RequestMapping("/showLanguages")

    public String showLanguages() {
        return "showLanguages";
    }
    @RequestMapping("/showPosts")

    public String showPosts() {
        return "showPosts";
    }

    @RequestMapping("/displayLanguages")
    public ModelAndView listLanguages() {
        ArrayList<LanguagesEntity> languageList = getAllLanguages();
        return new
                ModelAndView("home", "lList", languageList);

    }
    private ArrayList<LanguagesEntity> getAllLanguages() {
        Session s = getSession();
        Criteria l = s.createCriteria(LanguagesEntity.class);
        return (ArrayList<LanguagesEntity>) l.list();
    }

    @RequestMapping("/displayPosts")
    public ModelAndView listPosts(@RequestParam("languageId") int languageId) {

        ArrayList<PostsEntity> postsList = getAllPosts(languageId);
        return new
                ModelAndView("showPosts", "pList", postsList);

    }
    private ArrayList<PostsEntity> getAllPosts(int languageId) {
        Session s = getSession();
        Criteria p = s.createCriteria(PostsEntity.class);
        p.add(Restrictions.like("languageId", languageId));
        return (ArrayList<PostsEntity>) p.list();
    }
    @RequestMapping("/displayComments")
    public ModelAndView listComments(@RequestParam("postId") int postId,
                                     Model model) {
        Session s = getSession();
        PostsEntity temp = (PostsEntity) s.get(PostsEntity.class, postId);
        model.addAttribute("postTitle",temp.getPostTitle());
        model.addAttribute("postDescription",temp.getPostDescription());
        ArrayList<CommentsEntity> commentsList = getAllComments(postId);
        return new
                ModelAndView("showComments", "cList", commentsList);

    }
    private ArrayList<CommentsEntity> getAllComments(int postId) {
        Session s = getSession();
        Criteria c = s.createCriteria(CommentsEntity.class);
        c.add(Restrictions.like("postId", postId));
        return (ArrayList<CommentsEntity>) c.list();
    }


}