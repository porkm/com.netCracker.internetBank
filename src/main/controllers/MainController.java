package main.controllers;

import main.bll.api.IServiceEmployed;
import main.configuration.IoCConfiguration;
import main.dal.entinties.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);
    IServiceEmployed service = context.getBean(IServiceEmployed.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping("/customer")
    public String listCustomer() {
        return "customer";
    }

    @RequestMapping("/actionCustomer")
    public ModelAndView actionForCustomer() {
        List<Customer> customerList;

        try {
            customerList = service.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            customerList = new ArrayList<>();
        }

        return new ModelAndView("actionCustomer", "action", customerList);
    }

    @RequestMapping("/addCard")
    public ModelAndView addCardForCustomer(Model model){


        return new ModelAndView("actionCustomer");


    }

}

