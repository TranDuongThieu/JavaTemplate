package hcmute.DAO;

import java.util.List;

import hcmute.entity.Book;
import hcmute.entity.Rating;

public interface IBookDAO {
	List<Rating> countReview(Book book);
}
