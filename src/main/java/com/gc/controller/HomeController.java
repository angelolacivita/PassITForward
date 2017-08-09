package com.gc.controller;

import com.gc.dao.CommentsDAO;
import com.gc.dao.UserDAO;
import com.gc.dao.WalletDAO;
import com.gc.factory.DaoFactory;
import com.gc.models.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/registration")
    //the String method returns the jsp page that we want to show
    public ModelAndView registration(Model model) {

        return new ModelAndView("registration", "command", new UsersEntity());
    }

    @RequestMapping("/registrationsuccess")
    //the String method returns the jsp page that we want to show
    public String registrationsuccess() {

        return "registrationsuccess";
    }

    @RequestMapping("/newcomment")
    public ModelAndView newcomment(Model model){

        return new ModelAndView("newcomment", "command", new CommentsEntity());
    }

    @RequestMapping("/create-comment")
    public String newcomment(@ModelAttribute CommentsEntity newcomment, Model model){
        CommentsDAO commentsdao = DaoFactory.getCommentsDaoInstance(DaoFactory.COMMENTS_HIBERNATE_DAO);
        commentsdao.save(newcomment);

        //model.addAttribute("userID", newcomment.getUserId());
        model.addAttribute("commentDescription", newcomment.getCommentDescription());
        //model.addAttribute("commentsId", newcomment.getCommentsId());
        //model.addAttribute("postID", newcomment.getPostId());

        return "comments";
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
    public ModelAndView listPosts(@RequestParam("languageId") int languageId,
                                  Model model) {
        Session s = getSession();
        LanguagesEntity temp = (LanguagesEntity) s.get(LanguagesEntity.class, languageId);
        model.addAttribute("language", temp.getLanguage());
        ArrayList<PostsEntity> postsList = getAllPosts(languageId);
        return new
                ModelAndView("challenges", "pList", postsList);

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
        model.addAttribute("postTitle", temp.getPostTitle());
        model.addAttribute("postDescription", temp.getPostDescription());
        ArrayList<CommentsEntity> commentsList = getAllComments(postId);
        return new
                ModelAndView("comments", "cList", commentsList);

    }

    private ArrayList<CommentsEntity> getAllComments(int postId) {
        Session s = getSession();
        Criteria c = s.createCriteria(CommentsEntity.class);
        c.add(Restrictions.like("postId", postId));
        return (ArrayList<CommentsEntity>) c.list();
    }


}