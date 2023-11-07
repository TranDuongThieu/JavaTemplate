package hcmute.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.entity.User;

public class AccountDAOImpl implements IAccountDAO {

	@Override
	public User Login(User account) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		System.out.println(account.getEmail() + " " + account.getPasswd());
		try {
			transaction.begin();
			String email = account.getEmail();
			User acc = entityManager.find(User.class, email);

			if (acc != null && acc.getPasswd().equals(account.getPasswd())) {
				String getUserQueryString = "SELECT u FROM User u WHERE u.account.email = :email";
				TypedQuery<User> query = entityManager.createQuery(getUserQueryString, User.class);
				query.setParameter("email", email);
				User user = query.getSingleResult();
				transaction.commit();
				return user;
			}
			transaction.rollback();
		} catch (Exception e) {
			// Handle exceptions here (e.g., log or throw)
			transaction.rollback();
		} finally {
			entityManager.close();
		}

		return null; // Return null if login fails
	}

}