package hcmute.entity;

import javax.persistence.*;

import hcmute.untils.compositeld.BookAuthorID;

@Entity
@Table(name = "book_author")
@IdClass(BookAuthorID.class)
public class BookAuthor {
	@Id
	@ManyToOne
	@JoinColumn(name = "bookid")
	private Book book;

	@Id
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	// Getters and setters
}
