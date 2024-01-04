package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Customer;
import com.crm.service.CustomerService;

//CustomerController.java

@RestController("/customers")
public class CustomerController {

 @Autowired
 private CustomerService customerService;

 @GetMapping
 public String getAllCustomers(Model model) {
     List<Customer> customers = customerService.getAllCustomers();
     model.addAttribute("customers", customers);
     return "customer/list";
 }

 @GetMapping("/{id}")
 public String getCustomerById(@PathVariable Long id, Model model) {
     Customer customer = customerService.getCustomerById(id);
     model.addAttribute("customer", customer);
     return "customer/details";
 }

 @GetMapping("/show")
 public String showCustomerForm(Model model) {
     model.addAttribute("customer", new Customer());
     return "customer/form";
 }

 @PostMapping("/create")
 public String createCustomer(@ModelAttribute Customer customer) {
     customerService.createCustomer(customer);
     return "redirect:/customers";
 }

 @GetMapping("/{id}/edit")
 public String showEditForm(@PathVariable Long id, Model model) {
     Customer customer = customerService.getCustomerById(id);
     model.addAttribute("customer", customer);
     return "customer/form";
 }

 @PostMapping("/{id}/edit")
 public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer updatedCustomer) {
     customerService.updateCustomer(id, updatedCustomer);
     return "redirect:/customers";
 }

 @GetMapping("/{id}/delete")
 public String deleteCustomer(@PathVariable Long id) {
     customerService.deleteCustomer(id);
     return "redirect:/customers";
 }
}
