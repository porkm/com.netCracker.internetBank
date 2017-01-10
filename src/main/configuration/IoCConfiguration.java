//package main.configuration;
//
//import main.bll.api.IServiceCustomer;
//import main.bll.api.IServiceEmployed;
//import main.bll.service.imp.ServiceCustomer;
//import main.bll.service.imp.ServiceEmployed;
//import main.dal.api.IContext;
//import main.dal.api.IRepository;
//import main.dal.api.IUnitOfWork;
//import main.dal.imp.contextdb.MySQLContext;
//import main.dal.entinties.*;
//import main.dal.imp.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class IoCConfiguration {
//
//
//    @Bean
//    IContext icontext(){
//        return new MySQLContext();
//    }
//    @Bean
//    IRepository<Card> cardrepository(){
//        return new CardRepo(icontext());
//    }
//    @Bean
//    IRepository<Credit> creditrepository(){
//        return new CreditRepo(icontext());
//    }
//    @Bean
//    IRepository<Employed> emplrepository(){
//        return new EmployedRepo(icontext());
//    }
//    @Bean
//    IRepository<Customer> custrepository(){
//        return new CustomerRepo(icontext());
//    }
//
//    @Bean
//    IRepository<Invoice> invrepository(){
//        return new InvoiceRepo(icontext());
//    }
//    @Bean
//    IRepository<Request> reqrepository(){
//        return new RequestRepo(icontext());
//    }
//
//
//
//    @Bean
//    IUnitOfWork iunitofwork(){
//        return new ContextUnitOfWork(icontext());
//    }
//
//    @Bean
//    IServiceEmployed iserviceimployed(){
//        return new ServiceEmployed(iunitofwork());
//    }
//
//    @Bean
//    IServiceCustomer iservicecustomer(){
//        return new ServiceCustomer(iunitofwork());
//    }
//
//
//}
//
