package main.controllers;

import main.bll.api.IServiceCustomer;
import main.bll.api.IServiceEmployed;
import main.bll.modeldto.TransferDTO;
import main.bll.service.util.TransferError;
import main.configuration.IoCConfiguration;
import main.dal.entinties.Customer;
import main.dal.entinties.Invoice;
import main.dal.entinties.Request;
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
public class CustomerController {

    ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);
    IServiceCustomer service = context.getBean(IServiceCustomer.class);

    @RequestMapping("/actionCustomer")
    public String actionForCustomer(HttpSession session) {

        if (session.getAttribute("userId")==null){
            return "redirect:/login";
        }
        return "actionCustomer";

    }

    @RequestMapping(value = "/makeTransfer/{id}", method = RequestMethod.GET)
    public ModelAndView addTransfer(@PathVariable("id") int id) {

        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setFromInvoiceId(id);
        return new ModelAndView("makeTransfer", "transferDTO", transferDTO );
    }

    @RequestMapping(value = "/makeTransfer", method = RequestMethod.POST)
    public String makeTransfer(HttpSession session, @ModelAttribute("transferDTO") TransferDTO transferDTO, Model model) {
        TransferError result;


        try {
            result =service.transferMoney(transferDTO);
        } catch (SQLException e) {
           // e.printStackTrace();
            result =TransferError.SQLERROR;
        }

        switch (result){
            case NOINVOICES:{

                model.addAttribute("errorTransfer", "Неверный номер счета");
                return "makeTransfer";
                //break;
            }
            case NOMONEY:{
                model.addAttribute("errorTransfer", "Недостаточно средств");
                return "makeTransfer";
                //break;
            }
            case OK:{
                if (session.getAttribute("userId")==null){
                    return "redirect:/login";
                   // break;
                }

            }
        }
        return "redirect:/seeInvoices/"+session.getAttribute("userId");
    }


    @RequestMapping(value = "/addRequest/{id}", method = RequestMethod.GET)
    public ModelAndView seeRequest(@PathVariable("id") int id) {

        Request request = new Request();
        request.setCustomerId(id);
        return new ModelAndView("addRequest", "request", request );
    }

    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    public String seeRequest(HttpSession session, @ModelAttribute("request") Request request, Model model) {
        try {
            service.inviteFriend(request.getCustomerId(), request.getFriend());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "redirect:/actionCustomer";
    }

}
