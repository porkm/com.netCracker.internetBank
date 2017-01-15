package main.controllers;


import main.bll.api.IServiceEmployed;
import main.bll.modeldto.CardDTO;
import main.bll.service.myexeption.InterneteBankExeption;
import main.bll.service.util.CardInfo;
import main.dal.entinties.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EmployedController {


    @Autowired
    private IServiceEmployed service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }


    @RequestMapping("/actionEmployed")
    public ModelAndView actionForEmployed(Model model) {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = service.getAll();
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return new ModelAndView("actionEmployed", "customerList", customerList);
        }
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
    public String addCustomer(@Valid @ModelAttribute("addCustomer") Customer addCustomer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "error");
            return null;
        }
        try {
            service.registerCustomer(addCustomer);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return "redirect:/actionEmployed";
        }
    }


    //endregion

    //region Показать список счетов
    @RequestMapping(value = "/seeInvoices/{id}", method = RequestMethod.GET)
    public ModelAndView getListInvoices(HttpSession session, @PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("userId", session.getAttribute("userId"));
        //получить все счета выбранного клиента - id
        List<Invoice> listInvoices = new ArrayList<>();

        try {
            listInvoices = service.seeInvoises(id);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return new ModelAndView("seeInvoices", "listInvoices", listInvoices);
        }
    }
    //endregion

    //region Добавить счет
    @RequestMapping(value = "/addInvoice/{id}", method = RequestMethod.GET)
    public ModelAndView addInvoice(@PathVariable("id") int id) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(id);
        return new ModelAndView("addInvoice", "invoice", invoice);
    }

    @RequestMapping(value = "/addInvoice", method = RequestMethod.POST)
    public String addInvoice(@ModelAttribute("invoice") Invoice addInvoice, Model model) {
        try {
            service.addInvoice(addInvoice);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return "redirect:/seeInvoices/" + addInvoice.getCustomerId();
        }

    }
    //endregion

    //region Показать список карт
    @RequestMapping(value = "/seeCard/{id}", method = RequestMethod.GET)
    public ModelAndView getListCard(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        //получить все карты выбранного клиента - id
        List<Card> listCards = new ArrayList<>();
        try {
            listCards = service.seeCards(id);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return new ModelAndView("seeCard", "listCards", listCards);
        }

    }
    //endregion

    //region Добавить карту
    @RequestMapping(value = "/addCard/{id}", method = RequestMethod.GET)
    public ModelAndView addCard(@PathVariable("id") int id, Model model) {
        CardDTO card = new CardDTO();
        card.setInvoceId(id);
        model.addAttribute("curr", CardInfo.CardCurrency.values());
        return new ModelAndView("addCard", "card", card);
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public String addCard(@Valid @ModelAttribute("card") CardDTO addCard, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("curr", CardInfo.CardCurrency.values());
            return null;
        }


        try {
            service.addCard(addCard);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return "redirect:/seeCard/" + addCard.getInvoceId();
        }

    }
    //endregion

    //region Показать список кредитов
    @RequestMapping(value = "/seeCredit/{id}", method = RequestMethod.GET)
    public ModelAndView getListCredit(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        //получить все кредиты выбранного клиента - id
        List<Credit> listCredit = new ArrayList<>();
        try {
            listCredit = service.seeCredit(id);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return new ModelAndView("seeCredit", "listCredit", listCredit);
        }
    }


    //endregion

    //region Добавить Кредит
    @RequestMapping(value = "/addCredit/{id}", method = RequestMethod.GET)
    public ModelAndView addCredit(@PathVariable("id") int id) {
        Credit credit = new Credit();
        credit.setCustomerId(id);
        return new ModelAndView("addCredit", "credit", credit);
    }

    @RequestMapping(value = "/addCredit", method = RequestMethod.POST)
    public String addCredit(@Valid @ModelAttribute("credit") Credit addCredit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return null;
        }
        try {
            service.addCredit(addCredit);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return "redirect:/seeCredit/" + addCredit.getCustomerId();
        }
    }
    //endregion


    //region Изменить пароль


    //endregion

    //region Добавить друга
    @RequestMapping(value = "/seeRequest", method = RequestMethod.GET)
    public ModelAndView getListRequest(Model model) {
        // model.addAttribute("id", id);
        List<Request> listRequest = new ArrayList<>();

        try {
            listRequest = service.checkRequest();
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return new ModelAndView("seeRequest", "listRequest", listRequest);
        }

    }


    @RequestMapping(value = "/seeRequest", method = RequestMethod.POST)
    public String addRequest(@ModelAttribute("request") Request addRequest, Model model) {

        try {
            service.registerFriend(addRequest);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        }
        try {
            service.getBonus(addRequest.getCustomerId());
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return "redirect:/actionEmployed";
        }

    }

    //endregion


}
