package hcmute.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.entity.User;

public class AccountDAOImpl implements IAccountDAO {

	@Override
	public User Login(String email, String passwd) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			String jpql = "SELECT u FROM User u WHERE u.email = :email";
			TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
			query.setParameter("email", email.trim());
			List<User> users = query.getResultList();
			User user = users.get(0);
			if (user.getPasswd().equals(passwd))
				return user;
			else return null;
		}

		catch (Exception e) {
			// Handle other exceptions here (e.g., log or throw)
			transaction.rollback();
		} finally {
			entityManager.close();
		}

		return null; // Return null if login fails
	}

}