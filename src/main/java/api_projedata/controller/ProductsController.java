package api_projedata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api_projedata.model.Products;
import api_projedata.repository.ProductRepository;

@RestController
public class ProductsController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public List<Products> getProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/products/{id}")
    public Products getProductById(@PathVariable Integer id) {
		return productRepository.findById(id).get();
	}
	
	@PostMapping("/products")
	public Products saveProduct(@RequestBody Products product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		
		productRepository.deleteById(id);
	}
	
	@PutMapping("/products/{id}")
	public Products updateProduct(@PathVariable Integer id,@RequestBody Products product) {
		Products newProduct = productRepository.findById(id).get();
		newProduct.setName(product.getName());
		newProduct.setValue(product.getValue());
		return productRepository.save(newProduct);
	}
}
