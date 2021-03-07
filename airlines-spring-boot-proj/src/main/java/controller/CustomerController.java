package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.LoginData;
import dto.LoginStatus;
import dto.RegisterStatus;
import dto.Status.StatusType;
import exception.CustomerServiceException;
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
		try {
			int customerNo = customerService.register(customer);
			
			RegisterStatus status = new RegisterStatus();
			status.setMessage("Registration successful!");
			status.setStatus(StatusType.SUCCESS);
			status.setRegisteredCustomerNo(customerNo);
			
			return status;
		}
		catch(CustomerServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/login")
	public @ResponseBody LoginStatus login(@RequestBody LoginData loginData) {
		try {
			Customer customer = customerService.login(loginData);
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Login successful!");
			//status.setCustomer(customer);
			status.setCustomerNo(customer.getCustomerNo());
			status.setName(customer.getName());
			return status;
		}
		catch(CustomerServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
