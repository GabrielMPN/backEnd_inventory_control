package api_projedata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api_projedata.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

	@Query (value="select products.*, products_feedstocks.quantity_feedstock, feedstocks.stock from products \r\n"
			+ "inner join products_feedstocks \r\n"
			+ "on products.code = products_feedstocks.product_fk\r\n"
			+ "inner join feedstocks\r\n"
			+ "on feedstocks.code = products_feedstocks.feedstock_fk\r\n"
			+ "order by code;", nativeQuery=true )
	List<Products> analyzeIfHaveFeedstock();
	
}
