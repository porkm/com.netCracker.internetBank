package main.controllers;

import main.bll.api.IServiceCustomer;
import main.bll.service.myexeption.InterneteBankExeption;
import main.dal.entinties.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

//    ApplicationContext context = new AnnotationConfigApplicationContext(IoCConfiguration.class);
//    IServiceCustomer service = context.getBean(IServiceCustomer.class);

    @Autowired
    private  IServiceCustomer service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(HttpSession session, Model model, @ModelAttribute("loginBean") Customer loginBean) {

        if (loginBean != null && loginBean.getLogin() != null & loginBean.getPassw() != null) {

            if (service.checkLoginPassw(loginBean)) {
                //get id user
                int id;
                try {
                    id = service.getIdByLogin(loginBean.getLogin());
                } catch (InterneteBankExeption interneteBankExeption) {
                    model.addAttribute("message", interneteBankExeption.getMessage());
                    return "login";
                }
                model.addAttribute("userId", id);
                session.setMaxInactiveInterval(60);
                session.setAttribute("userId", id);

                return "actionCustomer";
            } else {
                model.addAttribute("message", "Неверные данные");
                return "login";
            }
        } else {
            model.addAttribute("error", "Введите данные");
            return "login";
        }
    }
}