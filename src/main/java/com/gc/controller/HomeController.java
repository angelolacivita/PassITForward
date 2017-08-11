package com.gc.controller;

import com.gc.dao.*;
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

    @RequestMapping("/") // returns the login page
    //the String method returns the jsp page that we want to show
    public String login() {
        return "login";
    }

    @RequestMapping("/home") // this page shows the challenges for each language
    //the String method returns the jsp page that we want to show
    public ModelAndView home() {
        LanguagesDAO languagesDAO = DaoFactory.getLanguagesDaoInstance(DaoFactory.LANGUAGES_HIBERNATE_DAO);

        ArrayList<LanguagesEntity> languageList = languagesDAO.getAllLanguages();

        return new
                ModelAndView("home", "lList", languageList);
    }

    @RequestMapping("/challenges")
    //the String method returns the jsp page that we want to show
    public ModelAndView challenges(Model model, @RequestParam("languageId") int languageId) {
        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        ArrayList<PostsEntity> postsList = postsDAO.getAllPosts(model, languageId);

        return new
                ModelAndView("challenges", "pList", postsList);
    }

    @RequestMapping("/comments")
    public ModelAndView comments(Model model, @RequestParam("postId") int postId){
        CommentsDAO commentsDAO = DaoFactory.getCommentsDaoInstance(DaoFactory.COMMENTS_HIBERNATE_DAO);
        ArrayList<CommentsEntity> commentsList = commentsDAO.getAllComments(model, postId);

        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        ArrayList<PostsEntity> postsList = postsDAO.getAllPosts();
        model.addAttribute("pList",postsList);

        return new
                ModelAndView("comments","cList", commentsList);
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

    @RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
    //the String method returns the jsp page that we want to show
    public String loginsuccess(Model model, @RequestParam("tempCode") String code, HttpServletResponse response) {
//            (@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        Model model) {
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);

//
        String accessToken = OAuthMethods.getOAuthToken(code);
        response.addCookie(new Cookie("cookieToken", accessToken));
        model.addAttribute("token", accessToken);

        return "loginsucess";
        //if else statement
    }

    @RequestMapping("/submitslackmessage")
    public String submitslackmessage() {
        return "slackmessage";
    }



    @RequestMapping(value = "/slackmessagesuccess", method = RequestMethod.GET)
    public String privatemessage(@CookieValue("cookieToken") String cookieToken,@RequestParam("slackmessage") String message, @RequestParam("channel") String channel){
        OAuthMethods.sendPrivateMessage(message, cookieToken, channel);
        return "slackmessagesuccess";
    }

    @RequestMapping("cookieTest")
    public String cookieTest(@CookieValue("cookieToken") String cookieToken, Model model) {
        model.addAttribute("cookieTest", cookieToken);
        return "cookietest";
    }

    @RequestMapping("/tempPage")
    public String tempPage() {
        return "tempPage";
    }

    @RequestMapping("/logintest")
    //the String method returns the jsp page that we want to show
    public String loginTest() {


        return "tempPage";
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

    @RequestMapping("/registrationsuccess")
    //the String method returns the jsp page that we want to show
    public String registrationsuccess() {

        return "registrationsuccess";
    }

    @RequestMapping("/newcomment")
    public ModelAndView newcomment(@RequestParam("postId") int postId, Model model){
        CommentsDAO commentsdao = DaoFactory.getCommentsDaoInstance(DaoFactory.COMMENTS_HIBERNATE_DAO);
        ArrayList<CommentsEntity> commentsList = commentsdao.getAllComments(model, postId);

        return new ModelAndView("newcomment", "command", new CommentsEntity());
    }

    @RequestMapping("/create-comment")
    public String createcomment(@ModelAttribute CommentsEntity newComment, Model model,
                             @RequestParam("postId") int postId){
        CommentsDAO commentsdao = DaoFactory.getCommentsDaoInstance(DaoFactory.COMMENTS_HIBERNATE_DAO);
        commentsdao.save(newComment);

        return "redirect:comments?postId="+postId;
    }

@RequestMapping("/newchallenge")
    public ModelAndView newchallenge(@RequestParam("languageId") int languageId, Model model){
        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        ArrayList<PostsEntity> postsList = postsDAO.getAllPosts(model, languageId);

        return new ModelAndView("newchallenge", "command", new PostsEntity());
    }

    @RequestMapping("/create-challenge")

    public String createchallenge(@ModelAttribute PostsEntity newPosts, Model model,
                             @RequestParam("languageId") int languageId){
        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        postsDAO.save(newPosts);

        return "redirect:challenges?languageId="+languageId;
    }



}