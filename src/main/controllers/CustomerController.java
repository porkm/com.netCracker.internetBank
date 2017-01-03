package main.controllers;

import main.bll.api.IServiceCustomer;
import main.bll.api.IServiceEmployed;
import main.bll.modeldto.TransferDTO;
import main.configuration.IoCConfiguration;
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CustomerController {

    ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);
    IServiceCustomer service = context.getBean(IServiceCustomer.class);

    @RequestMapping("/actionCustomer")
    public String actionForCustomer() {
        return "login";
    }

    @RequestMapping(value = "/makeTransfer/{id}", method = RequestMethod.GET)
    public ModelAndView addTransfer(@PathVariable("id") int id) {

        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setFromInvoiceId(id);
        return new ModelAndView("makeTransfer", "transferDTO", transferDTO );
    }

    @RequestMapping(value = "/makeTransfer", method = RequestMethod.POST)
    public String addInvoice(@ModelAttribute("transferDTO") TransferDTO transferDTO) {

        try {
            service.transferMoney(transferDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "index";
    }


}
