package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class MyOrder {
	@Id
	@GeneratedValue
	private int orderId;
	private String orderName;
	private String clientName;
	private boolean status;
	//@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	//@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	//@OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
	@OneToMany(mappedBy = "order", cascade = CascadeType.MERGE)
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

	public MyOrder() {
	}

	public MyOrder(String orderName, String clientName, boolean status) {
		this.orderName = orderName;
		this.clientName = clientName;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void addOrderDetail(OrderDetail orderDetail) {
		this.orderDetails.add(orderDetail);
	}
}
