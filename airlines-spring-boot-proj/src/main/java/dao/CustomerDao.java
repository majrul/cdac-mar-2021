package dao;

import org.springframework.stereotype.Repository;

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
}
