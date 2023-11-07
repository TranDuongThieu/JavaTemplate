package hcmute.entity;

import javax.persistence.*;

import hcmute.untils.compositeld.RatingID;

@Entity
@Table(name = "rating")

@IdClass(RatingID.class)
public class Rating {
	@Id
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "bookid")
	private Book book;

	@Column(name = "rating")
	private int rating;

	@Column(name = "review_text", columnDefinition = "TEXT")
	private String reviewText;

	public Book getBook() {
		return book;
	}

	public int getRating() {
		return rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public User getUser() {
		return user;
	}
	// Getters and setters
}
