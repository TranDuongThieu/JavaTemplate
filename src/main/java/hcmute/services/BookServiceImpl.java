package hcmute.services;

import java.util.List;

import hcmute.DAO.BookDAOImpl;
import hcmute.DAO.UserDAOImpl;
import hcmute.entity.Book;
import hcmute.entity.Category;
import hcmute.entity.Product;
import hcmute.entity.Rating;
import hcmute.entity.User;

public class BookServiceImpl implements IBookService {
	BookDAOImpl bookDAO = new BookDAOImpl();

	@Override
	public List<Book> findAll() {
		return bookDAO.findAll();
	}

	@Override
	public List<Rating> countReview(Book books) {
		// TODO Auto-generated method stub
		return bookDAO.countReview(books);
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return bookDAO.findById(id);
	}

}
