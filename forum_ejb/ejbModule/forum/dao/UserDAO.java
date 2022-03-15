package forum.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jsfcourse.entities.User;

@Stateless
public class UserDAO {
	@PersistenceContext
	EntityManager em;

	public void create(User user) {
		em.persist(user);
	}
	public User merge(User user) {
		return em.merge(user);
	}
	public void remove(User user) {
		em.remove(em.merge(user));
	}
}
