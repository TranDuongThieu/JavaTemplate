package hcmute.untils.compositeld;

import java.io.Serializable;
import java.util.Objects;

public class BookAuthorID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int book; // This should match the type of the book's primary key
	private int author; // This should match the type of the author's primary key

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BookAuthorID that = (BookAuthorID) o;
		return book == that.book && author == that.author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, author);
	}
	// Constructors, equals, and hashCode methods (if needed)
}
