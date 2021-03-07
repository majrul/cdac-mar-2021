package service;

import dto.BookingData;
import dto.LoginData;
import model.Customer;

public interface CustomerService {

	int register(Customer customer);
	Customer login(LoginData loginData);

	void bookFlight(BookingData bookingData);


}