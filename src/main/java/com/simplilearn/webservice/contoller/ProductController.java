package com.simplilearn.webservice.contoller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Product;

@RestController
public class ProductController {

	List<Product> products = new ArrayList<Product>();

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		if (products.isEmpty()) {
			addDefaultData();
		}
		return products;
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public Product getProduct(@RequestParam("name") String name) {
		for (Product product : products) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Product searchProduct(@RequestParam("name") String name) {
		for (Product product : products) {
			if (product.getName().contains(name)) {
				return product;
			}
		}
		return null;
	}

	// add product
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public List<Product> addProduct(@RequestBody Product product) {
		products.add(product);
		return products;
	}

	// update product
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		for (int index = 0; index < products.size(); index++) {
			if(products.get(index).getId()== product.getId()) {
				products.set(index, product);
				return product;
			}
		}
		return null;
	}
	
	// delete product
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") int id) {
		for (int index = 0; index < products.size(); index++) {
			if(products.get(index).getId()== id) {
				Product remove = products.get(index);
				products.remove(remove);
				return remove;
			}
		}
		return null;
	}
	
	//add default data when list is empty
	private void addDefaultData() {
		products.add(new Product(10001, "HP 10012RED Model laptop", 8993.994, "It is a laptop", true, new Date()));
		products.add(
				new Product(10002, "Apple MAC book 9345MSLV series", 10993.994, "It is a laptop", true, new Date()));
		products.add(
				new Product(10003, "Dell slim book 98456ERSD series", 8993.994, "It is a laptop", false, new Date()));
		products.add(
				new Product(10004, "Lenovo slim book QURW954756 model", 12993.994, "It is a laptop", true, new Date()));
	}
}
