package main.controllers;


import main.bll.api.IServiceEmployed;
import main.bll.modeldto.CreditDTO;
import main.configuration.IoCConfiguration;
import main.dal.entinties.Card;
import main.dal.entinties.Credit;
import main.dal.entinties.Customer;
import main.dal.entinties.Invoice;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        return new ModelAndView("actionEmployed", "customerList", customerList);
    }
    //region Добавить клиента
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
        return "redirect:/actionEmployed";
    }


    //endregion

    //region Показать список счетов
    @RequestMapping(value = "/seeInvoices/{id}", method = RequestMethod.GET)
    public ModelAndView getListInvoices(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        //получить все счета выбранного клиента - id
        List<Invoice> listInvoices;
        try {
            listInvoices = service.seeInvoises(id);
        } catch (SQLException e) {
            e.printStackTrace();
            listInvoices = new ArrayList<>();
        }
        return new ModelAndView("seeInvoices", "listInvoices", listInvoices );
    }
    //endregion

    //region Добавить счет
    @RequestMapping(value = "/addInvoice/{id}", method = RequestMethod.GET)
    public ModelAndView addInvoice(@PathVariable("id") int id) {
        Invoice invoice = new Invoice(0,0,id);
        return new ModelAndView("addInvoice", "invoice", invoice );
    }

    @RequestMapping(value = "/addInvoice", method = RequestMethod.POST)
    public String addInvoice(@ModelAttribute("invoice") Invoice addInvoice) {

        service.createInvoice(addInvoice);

        return "redirect:/seeInvoices/"+addInvoice.getCustomerId();
    }
    //endregion

    //region Показать список карт
    @RequestMapping(value = "/seeCard/{id}", method = RequestMethod.GET)
    public ModelAndView getListCard(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        //получить все карты выбранного клиента - id
        List<Card> listCards;

        try {
            listCards = service.seeCards(id);
        } catch (SQLException e) {
            e.printStackTrace();
            listCards = new ArrayList<>();
        }
        return new ModelAndView("seeCard", "listCards", listCards );
    }
    //endregion

    //region Добавить карту
    @RequestMapping(value = "/addCard/{id}", method = RequestMethod.GET)
    public ModelAndView addCard(@PathVariable("id") int id) {
        Card card = new Card();
        card.setInvoceId(id);
        return new ModelAndView("addCard", "card", card );
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public String addCard(@ModelAttribute("card") Card addCard) {
        try {
            service.addCard(addCard.getInvoceId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/seeCard/"+addCard.getInvoceId();
    }
    //endregion

    //region Показать список кредитов
    @RequestMapping(value = "/seeCredit/{id}", method = RequestMethod.GET)
    public ModelAndView getListCredit(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        //получить все кредиты выбранного клиента - id
        List<Credit> listCredit;
        try {
            listCredit = service.seeCredit(id);
        } catch (SQLException e) {
            e.printStackTrace();
            listCredit = new ArrayList<>();
        }


        return new ModelAndView("seeCredit", "listCredit", listCredit );
    }


    //endregion

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    //region Добавить Кредит
    @RequestMapping(value = "/addCredit/{id}", method = RequestMethod.GET)
    public ModelAndView addCredit(@PathVariable("id") int id) {
        Credit credit = new Credit();
        credit.setCustomerId(id);
        return new ModelAndView("addCredit", "credit", credit );
    }

    @RequestMapping(value = "/addCredit", method = RequestMethod.POST)
    public String addCredit(@ModelAttribute("credit") Credit addCredit) {

        service.addCredit(addCredit);

        return "redirect:/seeCredit/"+addCredit.getCustomerId();
    }
    //endregion


}
