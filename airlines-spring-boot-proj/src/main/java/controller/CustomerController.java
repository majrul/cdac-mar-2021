package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Customer;
import service.CustomerService;

@RestController
//@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	//@RequestMapping(path = "/register", method = RequestMethod.POST)
	public @ResponseBody String register(@RequestBody Customer customer) {
		System.out.println(customer);
		customerService.register(customer);
		return "Registration successful!";
	}
	
}
