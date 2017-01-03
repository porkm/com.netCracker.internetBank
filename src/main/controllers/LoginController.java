package main.controllers;

import main.bll.api.IServiceCustomer;
import main.configuration.IoCConfiguration;
import main.dal.entinties.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);
    IServiceCustomer service = context.getBean(IServiceCustomer.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") Customer loginBean) {
        if (loginBean != null && loginBean.getLogin() != null & loginBean.getPassw() != null) {

            //todo add session

            if (service.checkLoginPassw(loginBean)) {
                //get id user
                int id =service.getIdByLogin(loginBean.getLogin());
                model.addAttribute("userId", id);
                return "actionCustomer";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
}