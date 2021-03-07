package dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import dto.SearchData;
import model.Flight;

@Repository
public class CustomerDao extends GenericDao {
	
	public boolean isCustomerPresent(String email) {
		return (Long)
				entityManager
				.createQuery("select count(c) from Customer c where c.email = :email")
				.setParameter("email", email)
				.getSingleResult() == 1 ? true : false;
	}
	
	public int fetch(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select c.customerNo from Customer c where c.email = :email and c.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
	}

	public List<Flight> fetch(SearchData searchData) {
		String q = "select f from Flight f join fetch f.schedules s"
					+ " where f.source = :source and f.destination = :destination"
					+ " and s.scheduleDate = :date and s.availableSeats >= :passengers";
		return entityManager
				.createQuery(q, Flight.class)
				.setParameter("source", searchData.getFrom())
				.setParameter("destination", searchData.getTo())
				.setParameter("date", searchData.getDepartureDate())
				.setParameter("passengers", searchData.getNoOfPassengers())
				.getResultList();
	}
}
