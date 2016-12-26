package main.controllers;

import main.bll.api.IServiceCustomer;
import main.bll.service.imp.ServiceCustomer;
import main.configuration.IoCConfiguration;
import main.dal.api.IUnitOfWork;
import main.dal.entinties.Customer;
import main.dal.entinties.Invoice;
import main.dal.imp.ContextUnitOfWork;
import main.dal.imp.contextdb.MySQLContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);

    IServiceCustomer service = context.getBean(IServiceCustomer.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {


        List<Invoice> listInvoice = new ArrayList<>();
        try {
            listInvoice = service.seeInvoises(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (listInvoice.get(0) == null) {
            return "index";
        }

        double invoice = 5;//listInvoice.get(0).getBalance();
        model.addAttribute("listInvoice", invoice);
        return "index";
    }

}

