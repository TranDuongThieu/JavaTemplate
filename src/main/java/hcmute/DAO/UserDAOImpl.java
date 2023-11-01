package hcmute.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.entity.Category;

public class UserDAOImpl implements IUserDAO {

	@Override
	public List<Category> findAllCate() {

		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			// Create a JPQL query to select all categories from the database
			String jpql = "SELECT c FROM Category c";
			TypedQuery<Category> query = enma.createQuery(jpql, Category.class);

			// Execute the query and return the list of categories
			List<Category> categories = query.getResultList();
			for (Category cate : categories) {
				System.out.println(cate.getCateName());
			}
			return categories;
		} finally {
			enma.close();
		}
	}

}
