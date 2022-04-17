package api_projedata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feedstocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;

    @Column(length = 50, nullable = false, unique = true)
	private String name;
	
    @Column(nullable = false)
	private Integer stock;
}
