package com.demo.food.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.food.entity.Cartz;
import com.demo.food.entity.Customer;
import com.demo.food.entity.FoodItems;
import com.demo.food.repository.CartzRepository;
import com.demo.food.repository.CustomerRepository;
import com.demo.food.repository.FoodItemsRepository;
import com.demo.food.util.PDFGenerator;
import com.demo.food.util.SendMail;

@Controller

public class CartController {

	private static String folderPath = "F:\\Rakesh Hedge Workspace\\CartService\\Invoice\\";

	@Autowired
	private SendMail sendMail;

	@Autowired
	private PDFGenerator pdfGen;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FoodItemsRepository foodItemsRepository;

	@Autowired
	private CartzRepository cartzRepository;

//	@RequestMapping("/showsearch")
//	public String showSearch() {
//		return "SearchItem";
//	}

	@RequestMapping("/showsearch")
	public String items(ModelMap modelMap) {

		List<FoodItems> items = foodItemsRepository.findAll();
		modelMap.addAttribute("item", items);
		return "SearchItem";

	}

	@RequestMapping("/searchItem")
	public String findItem(@RequestParam(value = "itemName") String itemName, ModelMap modelMap) {

		List<FoodItems> item = foodItemsRepository.searchByItemNameLike(itemName);

		modelMap.addAttribute("item", item);
		return "displayItem";
	}

	@RequestMapping("/showAddCart")
	public String showAddCart(@RequestParam("itemId") Long itemId, ModelMap modelMap) {
		Optional<FoodItems> findById = foodItemsRepository.findById(itemId);
		FoodItems item = findById.get();
		modelMap.addAttribute("item", item);
		return "showAddCart";
	}

	@RequestMapping("/addCart")
	public String addOrder(@RequestParam("itemId") Long itemId, @RequestParam("customerName") String customerName,
			@RequestParam("customerAddress") String customerAddress, @RequestParam("email") String email,
			ModelMap modelMap) {

		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setCustomeAddress(customerAddress);
		customer.setEmail(email);

		customerRepository.save(customer);

		Optional<FoodItems> findById = foodItemsRepository.findById(itemId);
		FoodItems item = findById.get();

		Cartz cart = new Cartz();

		cart.setCustomer(customer);
		cart.setFoodItems(item);
		cart.setConfirmOrder(false);

		cartzRepository.save(cart);

		modelMap.addAttribute("customerName", customerName);
		modelMap.addAttribute("address", customerAddress);
		modelMap.addAttribute("email", email);

		modelMap.addAttribute("itemName", item.getItemName());
		modelMap.addAttribute("price", item.getPrice());
		modelMap.addAttribute("RestId", item.getRestaurantId());

		pdfGen.generatePDF(folderPath + "Invoice" + customer.getCustomerId() + ".pdf", customer.getCustomerName(),
				customer.getEmail(), customer.getCustomeAddress(), item.getItemName(), item.getPrice());

		sendMail.sendItinerary(customer.getEmail(), "Order Details", folderPath + "invoice" + customer.getCustomerId(),
				"invoice" + customer.getCustomerId() + ".pdf");

		return "confirmationPage";

	}
}
