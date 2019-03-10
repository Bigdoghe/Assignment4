package com.hxy.model;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordertable")
public class Order implements Serializable{
	
	@Id @GeneratedValue @Column(name="id")
	private int id;
	@Column(name="productid")
	private int productid;
	@Column(name="quantity")
	private int quantity;
	@Column(name="username")
	private String username;

	public Order() {}
	
	public Order(int productid, int quantity,String username) {
		super();
		this.productid = productid;
		this.quantity = quantity;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}