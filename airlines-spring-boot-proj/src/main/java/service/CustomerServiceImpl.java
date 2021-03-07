package service;

import java.time.LocalDate;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import dto.BookingData;
import dto.LoginData;
import exception.CustomerServiceException;
import model.Booking;
import model.Customer;
import model.Schedule;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public int register(Customer customer) {
		if(!customerDao.isCustomerPresent(customer.getEmail())) {
			Customer updatedCustomer = (Customer) customerDao.store(customer);
			//send an email - that code can be fired from here
			return updatedCustomer.getCustomerNo();
		}
		else
			throw new CustomerServiceException("Customer already registered!");
	}
	
	@Override
	public Customer login(LoginData loginData) {
		try {
			if(customerDao.isCustomerPresent(loginData.getEmail())) {
				int customerNo = customerDao.fetch(loginData.getEmail(), loginData.getPassword());
				Customer customer = customerDao.fetch(Customer.class, customerNo);
				return customer;
			}
			else
				throw new CustomerServiceException("Customer does not exist!");
		}
		catch(EmptyResultDataAccessException | NoResultException e) {
			throw new CustomerServiceException("Invalid Email/Password");
		}
	}
	
	@Override
	public void bookFlight(BookingData bookingData) {
		Customer customer = customerDao.fetch(Customer.class, bookingData.getCustomerNo());
		Schedule schedule = customerDao.fetch(Schedule.class, bookingData.getScheduleNo());
		
		Booking booking = new Booking();
		booking.setBookingDate(LocalDate.now());
		booking.setAmount(5000);
		booking.setStatus("Confirmed");
		booking.setMobileNo(1234567890);
		booking.setCustomer(customer);
		booking.setSchedule(schedule);
		
		booking.setPassengers(bookingData.getPassengers());
		
	}
}
