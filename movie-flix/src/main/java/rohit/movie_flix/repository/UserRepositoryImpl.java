package rohit.movie_flix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import rohit.movie_flix.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findUser(String userId) {
		return em.find(User.class, userId);
	}
	
	@Override
	public User findUserByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findUserByEmail", User.class);
		query.setParameter("uEmail", email);
		List<User> users = query.getResultList();
		if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}
	
	@Override
	public User updateUser(User user) {
		 em.merge(user);
		 return user;
	}
	
	@Override
	public void deleteUser(User existing) {
		em.remove(existing);
		
	}

	@Override
	public User userValidate(String email, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.validateUser", User.class);
		query.setParameter("vuEmail", email);
		query.setParameter("vuPassword", password);
		List<User> users = query.getResultList();
		if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
