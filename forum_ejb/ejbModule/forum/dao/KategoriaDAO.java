package forum.dao;

import jsfcourse.entities.Kategoria;
import jsfcourse.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class KategoriaDAO {
	@PersistenceContext
	EntityManager em;
	
	public void create(Kategoria kategoria) {
		em.persist(kategoria);
	}
	public Kategoria merge(Kategoria kategoria) {
		return em.merge(kategoria);
	}
	public void remove(Kategoria kategoria) {
		em.remove(em.merge(kategoria));
	}
}
