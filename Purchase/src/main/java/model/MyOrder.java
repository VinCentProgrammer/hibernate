package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class MyOrder {
	@Id
	private String orderId;
	private String name;
	private Date orderDate;
	//@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId")
	private Customer customer;

	public MyOrder() {
	}

	public MyOrder(String orderId, String name, Date orderDate, Customer customer) {
		this.orderId = orderId;
		this.name = name;
		this.orderDate = orderDate;
		this.customer = customer;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "MyOrder [orderId=" + orderId + ", name=" + name + ", orderDate=" + orderDate + ", customer=" + customer
				+ "]";
	}

}
