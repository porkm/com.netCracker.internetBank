package main.controllers;

import main.bll.api.IServiceEmployed;
import main.configuration.IoCConfiguration;
import main.dal.entinties.Card;
import main.dal.entinties.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/employed")
    public String listCustomer() {
        return "employed";
    }

    @RequestMapping("/actionEmployed")
    public ModelAndView actionForEmployed() {
        List<Customer> customerList;

        try {
            customerList = service.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            customerList = new ArrayList<>();
        }
        return new ModelAndView("actionEmployed", "action", customerList);
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomer() {
        return "addCustomer";
    }
    @ModelAttribute("addCustomer")
    public Customer newCustomer() {
        return new Customer();
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addPayment(@ModelAttribute("addCustomer") Customer addCustomer) {
        service.registerCustomer(addCustomer);
        return "actionEmployed";
    }




    @RequestMapping(value = "/addCard/{id}", method = RequestMethod.GET)
    public String getPayment(@PathVariable("id") int id, Model model) {

        try {
            service.addCard(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "index";
    }

}

