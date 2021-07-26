package com.demo.food.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -6256284085224301829L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "CUSTOMER_ADDRESS")
	private String customeAddress;

	@Column(name = "EMAIL")
	private String email;
	



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customeAddress="
				+ customeAddress + ", email=" + email + "]";
	}

	public Customer() {
		super();
	}

	public Customer(Long customerId, String customerName, String customeAddress, String email)
//			List<FoodItems> foodItems) 
	{
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customeAddress = customeAddress;
		this.email = email;
//		this.foodItems = foodItems;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomeAddress() {
		return customeAddress;
	}

	public void setCustomeAddress(String customeAddress) {
		this.customeAddress = customeAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public List<FoodItems> getFoodItems() {
//		return foodItems;
//	}
//
//	public void setFoodItems(List<FoodItems> foodItems) {
//		this.foodItems = foodItems;
//	}


}
