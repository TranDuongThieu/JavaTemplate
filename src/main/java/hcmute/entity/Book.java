package hcmute.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookid")
	private int bookId;

	@Column(name = "isbn")
	private int isbn;

	@Column(name = "title", length = 200)
	private String title;

	@Column(name = "publisher", length = 100)
	private String publisher;

	@Column(name = "price")
	private double price;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "publish_date")
	@Temporal(TemporalType.DATE)
	private Date publishDate;

	@Column(name = "cover_image", length = 100)
	private String coverImage;

	@Column(name = "quantity")
	private int quantity;

	public int getBookId() {
		return bookId;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public String getDescription() {
		return description;
	}
	public int getIsbn() {
		return isbn;
	}
	public double getPrice() {
		return price;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getTitle() {
		return title;
	}
	// Getters and setters
}
