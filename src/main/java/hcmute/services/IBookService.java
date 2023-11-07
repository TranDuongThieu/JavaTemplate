package hcmute.services;

import java.util.List;

import hcmute.entity.Book;
import hcmute.entity.Rating;
import hcmute.entity.User;

public interface IBookService {
	List<Book> findAll();

	Book findById(int id);

	List<Rating> countReview(Book book);
}
