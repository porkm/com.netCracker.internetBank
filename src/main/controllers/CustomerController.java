package main.controllers;

import main.bll.api.IServiceCustomer;
import main.bll.modeldto.PayCredit;
import main.bll.modeldto.TransferDTO;
import main.bll.service.myexeption.InterneteBankExeption;
import main.dal.entinties.Invoice;
import main.dal.entinties.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CustomerController {


    @Autowired
    private IServiceCustomer service;

    @RequestMapping("/actionCustomer")
    public String actionForCustomer(HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }
        return "actionCustomer";
    }

    @RequestMapping(value = "/makeTransfer/{id}", method = RequestMethod.GET)
    public ModelAndView addTransfer(@PathVariable("id") int id) {

        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setFromInvoiceId(id);
        return new ModelAndView("makeTransfer", "transferDTO", transferDTO);
    }

    @RequestMapping(value = "/makeTransfer", method = RequestMethod.POST)
    public String makeTransfer(HttpSession session, @ModelAttribute("transferDTO") TransferDTO transferDTO, Model model) {
        try {
            service.transferMoney(transferDTO);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
            return "redirect:/seeInvoices/" + session.getAttribute("userId");
        }
        return "redirect:/seeInvoices/" + session.getAttribute("userId");
    }


    @RequestMapping(value = "/addRequest/{id}", method = RequestMethod.GET)
    public ModelAndView seeRequest(@PathVariable("id") int id) {

        Request request = new Request();
        request.setCustomerId(id);
        return new ModelAndView("addRequest", "request", request);
    }

    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    public String seeRequest(HttpSession session, @ModelAttribute("request") Request request, Model model) {

        try {
            service.inviteFriend(request.getCustomerId(), request.getFriend());
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
            return "redirect:/actionCustomer";
        }
        return "redirect:/actionCustomer";
    }


    @RequestMapping(value = "/makeNextPay/{id}", method = RequestMethod.GET)
    public ModelAndView makeNextPay(HttpSession session, @PathVariable("id") int id, Model model) {
        model.addAttribute("creditId", id);
        List<Invoice> invoices = new ArrayList<>();
        int userId = (Integer) session.getAttribute("userId");
        try {
            invoices = service.seeInvoises(userId);
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            return new ModelAndView("makeNextPay", "invoices", invoices);
        }
    }

    @RequestMapping(value = "/makeNextPay", method = RequestMethod.POST)
    public String makeNextPaySubmit(HttpSession session, @ModelAttribute("payCredit") PayCredit payCredit, Model model) {

        try {
            service.makeNextPay(payCredit.getCreditId(), payCredit.getInvoiceId());
        } catch (InterneteBankExeption interneteBankExeption) {
            model.addAttribute("message", interneteBankExeption.getMessage());
        } finally {
            int userId = (Integer) session.getAttribute("userId");
            return "redirect:/seeCredit/" + userId;

        }

    }

}
