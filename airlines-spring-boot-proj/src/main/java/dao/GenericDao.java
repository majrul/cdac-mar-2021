package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class GenericDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Object obj) {
		entityManager.persist(obj);
	}

	public <E> E fetch(Class<E> clazz, Object pk) {
		E e = entityManager.find(clazz, pk);
		return e;
	}

	public List<?> fetch(String namedQuery) {
		List<?> list = entityManager.createNamedQuery(namedQuery).getResultList();
		return list;
	}


}
