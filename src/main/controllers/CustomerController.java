package main.controllers;

import main.bll.api.IServiceCustomer;
import main.bll.api.IServiceEmployed;
import main.configuration.IoCConfiguration;
import main.dal.entinties.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CustomerController {

    ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);
    IServiceCustomer service = context.getBean(IServiceCustomer.class);

    @RequestMapping("/actionCustomer")
    public ModelAndView actionForCustomer() {
        List<Customer> customerList = new ArrayList<>();
//
//        try {
//            customerList = service.getAll();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            customerList = new ArrayList<>();
//        }
        return new ModelAndView("actionCustomer", "action", customerList);
    }


}
