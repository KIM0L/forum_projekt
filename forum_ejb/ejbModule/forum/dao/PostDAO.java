package forum.dao;

import jsfcourse.entities.Post;
import jsfcourse.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PostDAO {
	@PersistenceContext
	EntityManager em;
	
	public void create(Post post) {
		em.persist(post);
	}
	public Post merge(Post post) {
		return em.merge(post);
	}
	public void remove(Post post) {
		em.remove(em.merge(post));
	}
	
}
