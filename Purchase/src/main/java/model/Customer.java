package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
public class Customer {
	@Id
	private String customerId;
	private String name;
	private boolean gender;
	private String email;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	//@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<MyOrder> myOrders;

	public Customer() {
	}

	public Customer(String customerId, String name, boolean gender, String email) {
		this.customerId = customerId;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<MyOrder> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(List<MyOrder> myOrders) {
		this.myOrders = myOrders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", gender=" + gender + ", email=" + email
				+ ", myOrders=" + myOrders.size() + "]";
	}
}
