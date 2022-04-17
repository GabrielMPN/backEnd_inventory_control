package api_projedata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api_projedata.model.Feedstocks;

@Repository
public interface FeedstockRepository extends JpaRepository<Feedstocks, Integer>{

}
