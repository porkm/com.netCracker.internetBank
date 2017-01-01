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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployedController {
    ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);
    IServiceEmployed service = context.getBean(IServiceEmployed.class);

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

 /*Регистрация новых клиентов*/

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomer() {
        return "addCustomer";
    }

    @ModelAttribute("addCustomer")
    public Customer newCustomer() {
        return new Customer();
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("addCustomer") Customer addCustomer) {
        service.registerCustomer(addCustomer);
        return "actionEmployed";
    }



    //показать список счетов
    @RequestMapping(value = "/seeInvoices/{id}", method = RequestMethod.GET)
    public ModelAndView getListInvoices(@PathVariable("id") int id) {
        //получить все счета выбранного клиента - id
        List<Invoice> listInvoices;

        try {
            listInvoices = service.seeInvoises(id);
        } catch (SQLException e) {
            e.printStackTrace();
            listInvoices = new ArrayList<>();
        }
        return new ModelAndView("seeInvoices", "action", listInvoices );
    }

    //показать список карт
    @RequestMapping(value = "/seeCard/{id}", method = RequestMethod.GET)
    public ModelAndView getListCard(@PathVariable("id") int id) {
        //получить все карты выбранного клиента - id
        List<Card> listCards;

        try {
            listCards = service.seeCards(id);
        } catch (SQLException e) {
            e.printStackTrace();
            listCards = new ArrayList<>();
        }
        return new ModelAndView("seeCard", "action", listCards );
    }






    @RequestMapping(value = "/addNewCard/{id}", method = RequestMethod.GET)
    public String addCard(@PathVariable("id")  int id) {
        return "addNewCard";
    }

    @ModelAttribute("addCard")
    public Card newCard() {
        return new Card();
    }
//
//    @RequestMapping(value = "/addNewCard", method = RequestMethod.POST)
//    public String addCard(@ModelAttribute("addCard") Card addCard) {
//        try {
//            service.addCard(addCard.getInvoceId());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "actionEmployed";
//    }







    /*Выдача кредитов*/
}
