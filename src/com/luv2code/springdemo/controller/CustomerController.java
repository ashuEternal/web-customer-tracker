package com.luv2code.springdemo.controller;


import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject the service dependency
   @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listCustomers(Model model)
    {
        //get Customers from DAO
        List<Customer> customers = customerService.getCustomers();

        //Add the customers to Spring MVC Model
        model.addAttribute("customers",customers);

        return "list-customers";
    }


    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {

        //create model attribute to bind our form data
        Customer customer = new Customer();

        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @RequestMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer)
    {

        customerService.saveCustomer(customer);


        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,Model model)
    {
        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer",customer);


        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id,Model model)
    {
        customerService.deleteCustome(id);

        return "redirect:/customer/list";
    }

}
