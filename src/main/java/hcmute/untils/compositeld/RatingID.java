package hcmute.untils.compositeld;

import java.io.Serializable;
import java.util.Objects;

public class RatingID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user; // This should match the type of the User entity
	private int book; // This should match the type of the Book entity

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	// Constructors, equals, and hashCode methods (if needed)
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RatingID ratingID = (RatingID) o;
		return user == ratingID.user && book == ratingID.book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, book);
	}
}
