package com.demo.food.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "food_ITems")
public class FoodItems implements Serializable {

	private static final long serialVersionUID = -970370479907157956L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	private Long itemId;

	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "ITEM_AVAILABILITY")
	private Double itemAvailability;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "RESTAURANT_ID")
	private Long restaurantId;
	
	@Override
	public String toString() {
		return "FoodItems [itemId=" + itemId + ", itemName=" + itemName + ", itemAvailability=" + itemAvailability
				+ ", price=" + price + ", restaurantId=" + restaurantId + "]";
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemAvailability() {
		return itemAvailability;
	}

	public void setItemAvailability(Double itemAvailability) {
		this.itemAvailability = itemAvailability;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

}
