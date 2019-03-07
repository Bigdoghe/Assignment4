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

	public Order() {}
	
	public Order(int productid, int quantity) {
		super();
		this.productid = productid;
		this.quantity = quantity;
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
	
	

}