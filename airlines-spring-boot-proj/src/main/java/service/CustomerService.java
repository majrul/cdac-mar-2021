package service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.GenericDao;
import dto.BookingData;
import model.Booking;
import model.Customer;
import model.Schedule;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private GenericDao genericDao;
	
	public int register(Customer customer) {
		Customer updatedCustomer = (Customer) genericDao.store(customer);
		//send an email - that code can be fired from here
		return updatedCustomer.getCustomerNo();
	}
	
	public void bookFlight(BookingData bookingData) {
		Customer customer = genericDao.fetch(Customer.class, bookingData.getCustomerNo());
		Schedule schedule = genericDao.fetch(Schedule.class, bookingData.getScheduleNo());
		
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
