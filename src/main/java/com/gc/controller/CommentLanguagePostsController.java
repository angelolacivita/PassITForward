package com.gc.controller;

import com.gc.dao.CommentsDAO;
import com.gc.dao.PostsDAO;
import com.gc.dao.VotesDAO;
import com.gc.dao.WalletDAO;
import com.gc.factory.DaoFactory;
import com.gc.models.CommentsEntity;
import com.gc.models.PostsEntity;
import com.gc.models.VotesEntity;
import org.apache.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 */
@Controller
public class CommentLanguagePostsController {
    /**
     * @param model
     * @param languageId
     * @return
     */
    @RequestMapping("/challenges")
    //the String method returns the jsp page that we want to show
    public ModelAndView challenges(Model model, @RequestParam("languageId") int languageId) {
        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        ArrayList<PostsEntity> postsList = postsDAO.getAllPosts(model, languageId);
        model.addAttribute("msg", message);
        return new
                ModelAndView("challenges", "pList", postsList);
    }

    /**
     * @param model
     * @param postId
     * @return
     */
    @RequestMapping("/comments")
    public ModelAndView comments(Model model, @RequestParam("postId") int postId) {
        CommentsDAO commentsDAO = DaoFactory.getCommentsDaoInstance(DaoFactory.COMMENTS_HIBERNATE_DAO);
        ArrayList<CommentsEntity> commentsList = commentsDAO.getAllComments(model, postId);
        VotesDAO votesDAO = DaoFactory.getVotesDaoInstance(DaoFactory.VOTES_HIBERNATE_DAO);

        Map votesmap = votesDAO.totalVotes();
        model.addAttribute("votesmap", votesmap);
        //System.out.println(votesmap.get("8"));

        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        ArrayList<PostsEntity> postsList = postsDAO.getAllPosts();
        model.addAttribute("pList", postsList);
        model.addAttribute("msg2", msg2);
        model.addAttribute("msg3", msg3);

        return new
                ModelAndView("comments", "cList", commentsList);
    }

    /**
     * @param languageId
     * @param model
     * @return
     */
    @RequestMapping("/newchallenge")
    public ModelAndView newchallenge(@RequestParam("languageId") int languageId, Model model) {
        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        ArrayList<PostsEntity> postsList = postsDAO.getAllPosts(model, languageId);

        return new ModelAndView("newchallenge", "command", new PostsEntity());
    }

    /**
     * @param newPosts
     * @param model
     * @param languageId
     * @param userIdCookie
     * @return
     */
    private String message;
    @RequestMapping("/create-challenge")
    public String createchallenge(@ModelAttribute PostsEntity newPosts, Model model,
                                  @RequestParam("languageId") int languageId, @CookieValue("userIdCookie") String userIdCookie) {
        PostsDAO postsDAO = DaoFactory.getPostsDaoInstance(DaoFactory.POSTS_HIBERNATE_DAO);
        WalletDAO walletDAO = DaoFactory.getWalletDaoInstance(DaoFactory.WALLET_HIBERNATE_DAO);
        int currentBalance = walletDAO.getWallet(Integer.parseInt(userIdCookie));
        int postBalance = currentBalance - 5;
        if (postBalance < 0) {
            message = "You do not have a high enough wallet balance to make a new post.";
            return "redirect:challenges?languageId=" + languageId;

        } else {
            message = "";
            newPosts.setUserId(Integer.parseInt(userIdCookie));
            postsDAO.save(newPosts);
            walletDAO.debitFromWallet(5, Integer.parseInt(userIdCookie));
            return "redirect:challenges?languageId=" + languageId;
        }
    }

    /**
     * @param postId
     * @param model
     * @return
     */
    @RequestMapping("/newcomment")
    public ModelAndView newcomment(@RequestParam("postId") int postId, Model model) {
        CommentsDAO commentsdao = DaoFactory.getCommentsDaoInstance(DaoFactory.COMMENTS_HIBERNATE_DAO);
        ArrayList<CommentsEntity> commentsList = commentsdao.getAllComments(model, postId);


        return new ModelAndView("newcomment", "command", new CommentsEntity());

    }

    /**
     * @param newComment
     * @param model
     * @param postId
     * @param userIdCookie
     * @return
     */

    private String msg3;
    @RequestMapping("/create-comment")
    public String createcomment(@ModelAttribute CommentsEntity newComment, Model model,
                                @RequestParam("postId") int postId, @CookieValue("userIdCookie") String userIdCookie) {
        CommentsDAO commentsdao = DaoFactory.getCommentsDaoInstance(DaoFactory.COMMENTS_HIBERNATE_DAO);

        if (commentsdao.commentCheck(Integer.parseInt(userIdCookie),postId) == null) {

            newComment.setUserId(Integer.parseInt(userIdCookie));
            commentsdao.save(newComment);
            WalletDAO walletDAO = DaoFactory.getWalletDaoInstance(DaoFactory.WALLET_HIBERNATE_DAO);
            walletDAO.creditToWallet(2, Integer.parseInt(userIdCookie));

            msg3 = "";
            msg2 = "";
            return "redirect:comments?postId=" + postId;

        }
            msg2 = "";
            msg3 = "Your comment has already been registered for this post. You cannot comment again.";

            return "redirect:comments?postId=" + postId;

    }

    /**
     * @param userId
     * @param postId
     * @return
     */
    private String msg2;

    @RequestMapping("/upvote")
    public String upvote(Model model, @CookieValue("userIdCookie") String userIdCookie, @RequestParam("userId") int userId, @RequestParam("postId") int postId, @RequestParam("commentsId") int commentsId) {
        WalletDAO walletDAO = DaoFactory.getWalletDaoInstance(DaoFactory.WALLET_HIBERNATE_DAO);
        VotesDAO votesDAO = DaoFactory.getVotesDaoInstance(DaoFactory.VOTES_HIBERNATE_DAO);

//        votesDAO.totalVotes(commentsId);

        if (voterFraud(Integer.parseInt(userIdCookie), commentsId) == null) {

            votesDAO.vote(Integer.parseInt(userIdCookie), commentsId, 1);
            walletDAO.creditToWallet(1, userId);
            msg2 = "";
            msg3 = "";
            return "redirect:comments?postId=" + postId;

        }
            //msg2 = "Your vote has already been registered";
            msg3 = "";
            return "redirect:comments?postId=" + postId;

    }


    /**
     * @param userId
     * @param postId
     * @return
     */
    @RequestMapping("/downvote")
    public String downvote(@CookieValue("userIdCookie")String userIdCookie,@RequestParam("userId") int userId, @RequestParam("postId") int postId, @RequestParam("commentsId")int commentsId) {
        WalletDAO walletDAO = DaoFactory.getWalletDaoInstance(DaoFactory.WALLET_HIBERNATE_DAO);
        VotesDAO votesDAO = DaoFactory.getVotesDaoInstance(DaoFactory.VOTES_HIBERNATE_DAO);

        if (voterFraud(Integer.parseInt(userIdCookie), commentsId) == null) {

            votesDAO.vote(Integer.parseInt(userIdCookie), commentsId, -1);
            walletDAO.debitFromWallet(1, userId);
            msg2 = "";
            msg3 = "";
            return "redirect:comments?postId=" + postId;

        }
        //msg2 = "Your vote has already been registered";
        msg3 = "";
        return "redirect:comments?postId=" + postId;

    }


    private VotesEntity voterFraud (int userId, int commentId){

        VotesDAO votesDAO = DaoFactory.getVotesDaoInstance(DaoFactory.VOTES_HIBERNATE_DAO);
        return votesDAO.voteCheck(userId, commentId);
    }


}
