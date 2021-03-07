package service;

import java.util.List;

import dto.BookingData;
import dto.LoginData;
import dto.SearchData;
import model.Customer;
import model.Flight;

public interface CustomerService {

	int register(Customer customer);
	Customer login(LoginData loginData);

	void bookFlight(BookingData bookingData);
	List<Flight> search(SearchData searchData);
	Customer get(int customerNo);


}