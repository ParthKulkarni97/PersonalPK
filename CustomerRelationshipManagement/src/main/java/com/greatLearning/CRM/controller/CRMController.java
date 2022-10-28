package com.greatLearning.CRM.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.CRM.service.CRMService;
import com.greatLearning.CRM.entity.CRM_Entity;

@Controller
@RequestMapping("/customer")
public class CRMController {
	
	// inject the customer service
		@Autowired
		private CRMService customerService;
		
		@GetMapping("/list")
		public String listCustomers(Model theModel) {
			System.out.println("request recieved");
			// get customers from the customer service
			List<CRM_Entity> theCustomers = customerService.findAll();
			
			// add the customers to the model
			theModel.addAttribute("customers", theCustomers);
			
			return "list-customers";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			CRM_Entity theCustomer = new CRM_Entity();
			theModel.addAttribute("customers", theCustomer); // name value
			
			return "customer-form";
		}
		
		@PostMapping("/save")
		public String saveBook(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
				@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

			System.out.println(id);
			CRM_Entity crm;
			if (id != 0) {
				crm = customerService.findById(id);
				crm.setFirstName(firstName);
				crm.setLastName(lastName);
				crm.setEmail(email);
//				crm.setCountry(country);
			} else
				crm = new CRM_Entity(firstName, lastName, email);
			// save 
			customerService.save(crm);

			// use a redirect to prevent duplicate submissions
			return "redirect:/customer/list";

		}
		
//		@PostMapping("/saveCustomer")
//		public String saveCustomer(@ModelAttribute("customer") CRM_Entity theCustomer) {
//			
//			// save the customer using service
//			customerService.saveCustomer(theCustomer);	
//			
//			return "redirect:/customer/list";
//		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("id") int theId,
										Model theModel) {
			
			// get the customer from our service
			CRM_Entity theCustomer = customerService.findById(theId);	
			
			// set customer as a model attribute to pre-populate the 
			// form that we will send the user to
			theModel.addAttribute("customers", theCustomer);
			
			// send over to the form	
			return "customer-form";
		}
		
		@GetMapping("/delete")
		public String deleteCustomer(@RequestParam("id") int theId) {
			
			customerService.deleteById(theId);
			
			return "redirect:/customer/list";
		}
		
		

}
