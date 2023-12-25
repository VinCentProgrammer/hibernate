package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private int numOrder;
	private double priceUnit;
	@ManyToOne
	@JoinColumn(name = "orderId")
	private MyOrder order;
	
	public OrderDetail() {
	}
	public OrderDetail(String productName, int numOrder, double priceUnit, MyOrder order) {
		this.productName = productName;
		this.numOrder = numOrder;
		this.priceUnit = priceUnit;
		this.order = order;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getNumOrder() {
		return numOrder;
	}
	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}
	public double getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(double priceUnit) {
		this.priceUnit = priceUnit;
	}
	public MyOrder getOrder() {
		return order;
	}
	public void setOrder(MyOrder order) {
		this.order = order;
	}
	
	
}
