package com.simplilearn.webservice.contoller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Product;
import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.ProductNotFound;
import com.simplilearn.webservice.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	// get all products
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		List<Product> productList = productRepository.findAll();
		if (productList.isEmpty()) {
			throw new ProductNotFound("Product not found, product list is empty");
		}
		return productList;
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		Optional<Product> productData = productRepository.findById(id);
		if (productData.isPresent()) {
			return productData.get();
		}
		throw new ProductNotFound("Product not found with given id " + id);
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public List<Product> getProduct(@RequestParam("name") String name) {
		List<Product> productList = productRepository.findByName(name);
		if (!productList.isEmpty()) {
			return productList;
		}
		throw new ProductNotFound("Product not found with given name '" + name + "'");
	}
	
	@RequestMapping(value = "/filter/product", method = RequestMethod.GET)
	public List<Product> filterProduct(@RequestParam("available") boolean available) {
		List<Product> productList = productRepository.findByIsAvailable(available);
		if (!productList.isEmpty()) {
			return productList;
		}
		throw new ProductNotFound("Product not found with avaialable status '" + available + "'");
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Product> searchProduct(@RequestParam("name") String name) {
		List<Product> productList = productRepository.searchByName(name);
		if (!productList.isEmpty()) {
			return productList;
		}
		throw new ProductNotFound("Product not found with given text '" + name + "'");
	}

	// add product
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product addProduct(@RequestBody(required = false) Product product) {
		if (product != null) {
			if (product.getName() != null) {
				return productRepository.save(product);
			} else {
				throw new InvalidProductException("Product can not be created , required *name filed missing");
			}
		}
		throw new InvalidProductException("Product can not be created , required fileds missing");
	}

	// update product
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		Optional<Product> productData = productRepository.findById(product.getId());
		if (productData.isPresent()) {
			return productRepository.save(product);
		}
		throw new ProductNotFound("Product not found with given id " + product.getId());
	}

	// delete product
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") int id) {
		Optional<Product> productData = productRepository.findById(id);
		if (productData.isPresent()) {
			productRepository.delete(productData.get());
			return productData.get();
		}
		throw new ProductNotFound("Product not found with given id " + id);
	}
}
