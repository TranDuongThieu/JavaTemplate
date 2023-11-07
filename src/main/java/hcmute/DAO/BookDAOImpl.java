package hcmute.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.entity.Book;
import hcmute.entity.Rating;

public class BookDAOImpl extends AbstractDao<Book> implements IBookDAO {

	public BookDAOImpl() {
		super(Book.class);
	}

	@Override
	public List<Rating> countReview(Book book) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<Integer> reviews = new ArrayList<>();

		int id = book.getBookId();

		TypedQuery<Rating> query = entityManager.createQuery("SELECT r FROM Rating r WHERE r.book.id = :bookId",
				Rating.class);
		query.setParameter("bookId", id);

		List<Rating> result = query.getResultList();

		return result;
	}

}
