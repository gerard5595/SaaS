package com.saas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saas.entity.Customer;
import com.saas.entity.Product;
import com.saas.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	List<Product> all() {
		return productRepository.findAll();
	}

	@PostMapping("/products")
	Product newProduct(@RequestBody Product newProduct) {
		return productRepository.save(newProduct);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String title) {
		try {
			List<Product> products = new ArrayList<Product>();
			if (title == null)
				productRepository.findAll().forEach(products::add);
			else
				productRepository.findByTitleContaining(title).forEach(products::add);
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getTutorialById(@PathVariable("id") long id) {
		Optional<Product> productData = productRepository.findById(id);
		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/products")
	public ResponseEntity<Product> createTutorial(@RequestBody Product product) {
		try {
			Product _product = productRepository.save(
					new Product(product.getProductName(), product.getPrice(), product.getRate(), product.isPublished(),
							product.isAuthorized(), product.getPurchaseDate(), product.getReleaseDate()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 @PutMapping("/products/{id}")
	 Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
	    return productRepository.findById(id)
	      .map(_product -> {
	    	  _product.setProductName(_product.getProductName());
				_product.setPrice(_product.getPrice());
				_product.setRate(_product.getRate());
				_product.setPublished(_product.isPublished());
				_product.setAuthorized(_product.isAuthorized());
				_product.setPurchaseDate(_product.getPurchaseDate());
				_product.setReleaseDate(_product.getReleaseDate());
	        return productRepository.save(_product);
	      })
	      .orElseGet(() -> {
	        newProduct.setId(id);
	        return productRepository.save(newProduct);
	      });
	  }

//	@PutMapping("/products/{id}")
//	public ResponseEntity<Product> updateTutorial(@PathVariable("id") long id, @RequestBody Product product) {
//		Optional<Product> productData = productRepository.findById(id);
//		if (productData.isPresent()) {
//			Product _product = productData.get();
//			_product.setProductName(product.getProductName());
//			_product.setPrice(product.getPrice());
//			_product.setRate(product.getRate());
//			_product.setPublished(product.isPublished());
//			_product.setAuthorized(product.isAuthorized());
//			_product.setPurchaseDate(product.getPurchaseDate());
//			_product.setReleaseDate(product.getReleaseDate());
//			return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			productRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/products")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			productRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products/published")
	public ResponseEntity<List<Product>> findByPublished() {
		try {
			List<Product> products = productRepository.findByPublished(true);
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
