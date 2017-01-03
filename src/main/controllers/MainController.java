package main.controllers;

import main.bll.api.IServiceEmployed;
import main.configuration.IoCConfiguration;
import main.dal.entinties.Card;
import main.dal.entinties.Customer;
import main.dal.entinties.Invoice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping("/employed")
    public String listCustomer() {
        return "employed";
    }

    @RequestMapping("/customer")
    public String listEmpoloyed(HttpSession session) {
        if (session.getAttribute("userId")==null){
            return "redirect:/login";
        }
        return "actionCustomer";
    }








}

