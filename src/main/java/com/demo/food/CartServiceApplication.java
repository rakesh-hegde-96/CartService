package com.demo.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.food.util.PDFGenerator;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
		
		
		
	PDFGenerator 	pdfGen=new PDFGenerator();
	
		pdfGen.generatePDF("F:\\Rakesh Hedge Workspace\\CartService\\Invoice" + "invoice" + 1+".pdf", "Priya",
				 "rshegde0412@gmail.com", "Bangalore","Kesari Bath",
				50);
		
	}

}
