package com.gc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by angelo on 8/7/17.
 */



@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld()
    {
        return new
                ModelAndView("welcome","message","Hello World");

    }

}