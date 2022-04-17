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
import org.springframework.web.bind.annotation.RestController;

import api_projedata.model.Feedstocks;
import api_projedata.repository.FeedstockRepository;

@RestController
public class FeedstocksController {
	
	@Autowired
	private FeedstockRepository feedstockRepository;

	@GetMapping("/feedstocks")
	public List<Feedstocks> getFeedstocks() {
		return feedstockRepository.findAll();
	}
	
	@GetMapping("/feedstocks/{id}")
    public Feedstocks getFeedstockById(@PathVariable Integer id) {
		return feedstockRepository.findById(id).get();
	}
	
	@PostMapping("/feedstocks")
	public Feedstocks saveFeedstock(@RequestBody Feedstocks feedstock) {
		return feedstockRepository.save(feedstock);
	}
	
	@DeleteMapping("/feedstocks/{id}")
	public void deleteFeedstock(@PathVariable Integer id) {
		feedstockRepository.deleteById(id);
	}
	
	@PutMapping("/feedstocks/{id}")
	public Feedstocks updateFeedstock(@PathVariable Integer id,@RequestBody Feedstocks feedstock) {
		Feedstocks newFeedstock = feedstockRepository.findById(id).get();
		newFeedstock.setName(feedstock.getName());
		newFeedstock.setStock(feedstock.getStock());
		return feedstockRepository.save(newFeedstock);
	}
}
