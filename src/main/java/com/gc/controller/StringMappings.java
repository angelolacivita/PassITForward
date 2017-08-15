package com.gc.controller;

import com.gc.dao.CommentsDAO;
import com.gc.dao.LanguagesDAO;
import com.gc.dao.PostsDAO;
import com.gc.dao.WalletDAO;
import com.gc.factory.DaoFactory;
import com.gc.models.CommentsEntity;
import com.gc.models.LanguagesEntity;
import com.gc.models.PostsEntity;
import com.gc.models.WalletEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.MapKeyColumn;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
//@RequestMapping("link")
public class StringMappings {
    /**
     * @param request
     * @return
     */
    @RequestMapping("/") // returns the login page
    //the String method returns the jsp page that we want to show
    public ModelAndView login2(HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();
        String cookienamestring = "";
//        for (int i = 0; i < cookie.length; i++) {
//            Cookie cookiename = cookie[i];
//            cookienamestring = cookiename.getName();
//            if (cookienamestring.equals("userIdCookie")) {
//                LanguagesDAO languagesDAO = DaoFactory.getLanguagesDaoInstance(DaoFactory.LANGUAGES_HIBERNATE_DAO);
//                ArrayList<LanguagesEntity> languageList = languagesDAO.getAllLanguages();
//                return new
//                        ModelAndView("home", "lList", languageList);
//            }
//        }

        return new ModelAndView("login", "", "");
    }

    /**
     * @return
     */
    @RequestMapping("/about") // needs copy
    //the String method returns the jsp page that we want to show
    public String about() {
        return "about";
    }

    /**
     * @return
     */
    @RequestMapping("/contact")
    //the String method returns the jsp page that we want to show
    public String contact() {
        return "contact";
    }

    /**
     * @return
     */
    @RequestMapping("/submitslackmessage")
    public String submitslackmessage() {

        return "slackmessage";
    }

    /**
     * @return
     */
    @RequestMapping("/tempPage")
    public String tempPage() {

        return "tempPage";
    }

    /**
     * @return
     */
    @RequestMapping("/registrationsuccess")
    //the String method returns the jsp page that we want to show
    public String registrationsuccess() {
        return "registrationsuccess";
    }

    /**
     * @return
     */
    @RequestMapping("/logintest") // returns the login page
    //the String method returns the jsp page that we want to show
    public String logintest() {

        return "loginTEST";
    }

    /**
     * @param model
     * @param userIdCookie
     * @param userNameCookie
     * @return
     */
    @RequestMapping("/dashboard")
    public ModelAndView dashboard(Model model, @CookieValue("userIdCookie") String userIdCookie, @CookieValue("userNameCookie") String userNameCookie) {
        CommentsDAO commentsDAO = DaoFactory.getCommentsDaoInstance(DaoFactory.COMMENTS_HIBERNATE_DAO);
        ArrayList<CommentsEntity> commentsList = commentsDAO.getUserComments(Integer.parseInt(userIdCookie));
        model.addAttribute("cList", commentsList);

        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        ArrayList<PostsEntity> postsList = postsDAO.getUserPosts(Integer.parseInt(userIdCookie));
        model.addAttribute("pList", postsList);

        WalletDAO walletDAO = DaoFactory.getWalletDaoInstance(DaoFactory.WALLET_HIBERNATE_DAO);
        int walletValue = walletDAO.getWallet(Integer.parseInt(userIdCookie));
        model.addAttribute("walletValue", walletValue);

        model.addAttribute("userName", userNameCookie);

        return new ModelAndView("dashboard", "command", "");
    }

}
