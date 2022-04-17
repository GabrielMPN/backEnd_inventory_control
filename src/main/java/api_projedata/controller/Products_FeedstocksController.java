package api_projedata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api_projedata.model.Products;
import api_projedata.model.Products_Feedstocks;
import api_projedata.repository.Product_FeedstockRepository;

@RestController
public class Products_FeedstocksController {
	
	@Autowired
	private Product_FeedstockRepository product_feedstockRepository;

	@GetMapping("/products_feedstocks")
	public List<Products_Feedstocks> getProducts_Feedstocks() {
		return product_feedstockRepository.findAll();
	}
	
	@GetMapping("/products_feedstocks/{productsfk}")
    public List<Products_Feedstocks> getProducts_FeedstockById(@PathVariable("productsfk") Products productsfk) {
		return product_feedstockRepository.findProductFk(productsfk);
	}
	
	@PostMapping("/products_feedstocks")
	public Products_Feedstocks saveProduct_Feedstock(@RequestBody Products_Feedstocks feedstock) {
		feedstock.setFeedstock_fk(feedstock.getFeedstock_fk());
		feedstock.setProduct_fk(feedstock.getProduct_fk());
		return product_feedstockRepository.save(feedstock);
	}
	
	@DeleteMapping("/products_feedstocks/products/{id}")
	public void deleteProductsfk(@PathVariable("id") Products id) {
		product_feedstockRepository.deleteProductsfk(id);
	}
	
	@DeleteMapping("/products_feedstocks/feedstocks/{id}")
	public void deleteFeedstocksfk(@PathVariable("id") Products id) {
		product_feedstockRepository.deleteFeedstocksfk(id);
	}
	
	@PutMapping("/products_feedstocks/{id}")
	public Products_Feedstocks updateProduct_Feedstock(@PathVariable Integer id,@RequestBody Products_Feedstocks product_feedstock) {
		Products_Feedstocks newProduct_Feedstock = product_feedstockRepository.findById(id).get();
		newProduct_Feedstock.setFeedstock_fk(product_feedstock.getFeedstock_fk());
		newProduct_Feedstock.setProduct_fk(product_feedstock.getProduct_fk());
		return product_feedstockRepository.save(newProduct_Feedstock);
	}
	
}
