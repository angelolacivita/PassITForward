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

    /**This is a RequestMapping that displays the home screen. It does a check on the userIdCookie and returns
     * either the login page if not logged in or the home page with a list of the challenges organized by programming language
     * @param model not used
     * @param request HTTPServletRequest to recall the userIdCookie
     * @return if cookie is present returns ModelAndView of home screen with a list of languages as model data, if cookie is missing returns a model of login page.
     */
    @RequestMapping("/home") // this page shows the challenges for each language
    //the String method returns the jsp page that we want to show
    //also redirects to the home page after loggin in with slack
    public ModelAndView home(Model model, HttpServletRequest request) {
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
        return new ModelAndView("login", "", "");
    }

    /**Depreceated???????
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(Model model) {

        model.addAttribute("button", "Sign in with Slack");
        model.addAttribute("isLogin", false);
        model.addAttribute("msg", message);
        return "login";
    }


    private UsersEntity loginUser;

    private String message;

    /**This is called from the login page after entering the username and password.
     * Calls the validUserAndPass method and returns null if no username and password is present
     * @param userName parameter is requested from login page
     * @param password parameter is represted from login page
     * @param model not used
     * @param request not used
     * @param response adds userIdCookie with value of userid (Interger is cast as string) and adds userNameCookie with value of username
     * @param session not used
     * @return returns loginsuccess page if username and password
     */
    @RequestMapping(value = "/loginUser")
    public String loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (validUserAndPass(userName, password) != null) {
            loginUser = validUserAndPass(userName, password);
            int userId = loginUser.getUserId();
            Cookie userCookie = new Cookie("userIdCookie", (Integer.toString(userId)));
            Cookie userNameCookie = new Cookie("userNameCookie", userName);
            userCookie.setMaxAge(60 * 60 * 24);
            userNameCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(userCookie);
            response.addCookie(userNameCookie);
            return "loginsuccess";
        } else {
            message = "Incorrect username or password";
            return "redirect:login";
        }
    }

    /**Method called by RequestMapping for /loginUser, calls UserDAO method getUser which
     * returns a UserEntity if username and password are valid
     * @param userName string passed in from RequestMapping /loginUser from login form
     * @param password string passed in from RequestMapping /loginUser from login form
     * @return UserEntity if username and password match and null if no method
     */
    private UsersEntity validUserAndPass(String userName, String password) {
        UserDAO userDAO = DaoFactory.getUserDaoInstance(DaoFactory.USERS_HIBERNATE_DAO);

        return userDAO.getUser(userName, password);
    }

    /**RequestMapping for loginsuccess page reached after successful login
     * @return loginsuccess.jsp
     */
    @RequestMapping("/loginsuccess")
    //the String method returns the jsp page that we want to show
    public String loginsuccess() {

        return "loginsuccess";
        //if else statement
    }

    /**Request Mapping for registration page which passes in a UsersEntity model for the Spring Registration form
     * @param model not used
     * @return registration form page with UsersEntity as attributes in the spring form
     */
    @RequestMapping("/registration")
    public ModelAndView registration(Model model) {
        model.addAttribute("message", message);
        return new ModelAndView("registration", "command", new UsersEntity());
    }

    /** Request mapping called after clicking create profile from registration page.
     * Creates a wallet with a default value of 10 if registration is successful
     * @param newUser ModelAttributes populated from spring form on registration page
     * @param model model holds attributes for user name and wallet value to display on registration success page
     * @return view of registration success with firstname and walletvalue as attributes
     */
    @RequestMapping("/create-profile")
    public String registration(@ModelAttribute UsersEntity newUser, Model model) {
        UserDAO userdao = DaoFactory.getUserDaoInstance(DaoFactory.USERS_HIBERNATE_DAO);
        ArrayList<UsersEntity> allUsers = userdao.getAllUsers();

        if (userdao.checkRegistry(newUser.getUserName(), newUser.getEmail()) != null ){
            message = "username or email already in use";
            return "redirect:registration";
        }

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

    /**Depreceated????
     * @param username
     * @param password
     * @param model
     * @return
     */
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

    /**RequestMapping for logout link at top of every page. Creates 3 cookies with same names as those created during
     * browseing the sites and sets the maxage to 0
     * @param response HttpServletResponse to call cookies
     * @return logout page
     */
    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie userCookie = new Cookie("userIdCookie", "");
        userCookie.setMaxAge(0);
        response.addCookie(userCookie);
        Cookie userCookie2 = new Cookie("cookieToken", "");
        userCookie2.setMaxAge(0);
        response.addCookie(userCookie2);
        Cookie userCookie3 = new Cookie("userNameCookie", "");
        userCookie3.setMaxAge(0);
        response.addCookie(userCookie3);
        return "logout";
    }

    /**RequestMapping for pleaselogin page which is what the user sees if trying to access
     * the home page without logging in
     * @return pleaselogin page
     */
    @RequestMapping("/pleaselogin")
    public String pleaselogin() {
        return "pleaselogin";
    }

}