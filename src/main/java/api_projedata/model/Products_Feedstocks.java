package api_projedata.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products_Feedstocks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

	@ManyToOne
	@JoinColumn(nullable = false, name = "product_fk")
	private Products product_fk;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "feedstock_fk")
	private Feedstocks feedstock_fk;
	
	@Column(nullable = false)
	private Integer quantity_feedstock;
}
