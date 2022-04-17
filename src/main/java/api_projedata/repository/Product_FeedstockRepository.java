package api_projedata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api_projedata.model.Products;
import api_projedata.model.Products_Feedstocks;

public interface Product_FeedstockRepository extends JpaRepository<Products_Feedstocks, Integer>{
	
	@Query("SELECT e FROM Products_Feedstocks e WHERE  e.product_fk=:productfk")
	List<Products_Feedstocks> findProductFk(@Param("productfk") Products  productfk);
	
	@Modifying
	@Transactional
	@Query(value="delete from products_feedstocks where product_fk = :id", nativeQuery=true)
	void deleteProductsfk(@Param("id") Products id);
	
	@Modifying
	@Transactional
	@Query(value="delete from products_feedstocks where feedstock_fk = :id", nativeQuery=true)
	void deleteFeedstocksfk(@Param("id") Products id);
}
