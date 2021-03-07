package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.RegisterStatus;
import dto.Status.StatusType;
import model.Customer;
import service.CustomerService;

@RestController
//@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	//@RequestMapping(path = "/register", method = RequestMethod.POST)
	public @ResponseBody RegisterStatus register(@RequestBody Customer customer) {
		int customerNo = customerService.register(customer);
		
		RegisterStatus status = new RegisterStatus();
		status.setMessage("Registration successful!");
		status.setStatus(StatusType.SUCCESS);
		status.setRegisteredCustomerNo(customerNo);
		
		return status;
	}
	
}
