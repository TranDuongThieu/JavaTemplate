package hcmute.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	private String productID;

	@Column(name = "Name", columnDefinition = "varchar(255)")
	private String name;

	@Column(name = "Description", columnDefinition = "varchar(15000)")
	private String description;

	@ManyToOne
	@JoinColumn(name = "CateID")
	private Category category;

	public Product() {
	}

	public Product(String name, String description, Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
