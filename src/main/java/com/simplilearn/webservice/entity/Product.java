package com.simplilearn.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products_data")
public class Product {

	// properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int id;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_price")
	private double price;
	
	@Column(name="product_desc")
	private String description;
	
	@Column(name="product_available")
	private boolean isAvailable;
	
	@Column(name="created_at")
	private Date createAt;

	// public get and sets methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	// constructor
	public Product() {
		super();
	}

	public Product(int id, String name, double price, String description, boolean isAvailable, Date createAt) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.createAt = createAt;
	}
	
	public Product(String name, double price, String description, boolean isAvailable, Date createAt) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", isAvailable=" + isAvailable + ", createAt=" + createAt + "]";
	}
}