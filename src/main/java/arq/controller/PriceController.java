package arq.controller;

import java.io.IOException;
import java.util.Date;

import arq.domain.Build;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newrelic.agent.deps.org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import arq.domain.Price;
import arq.repository.PriceRepository;

@RestController
@RequestMapping("${rest.base_path}/found-prices")
public class PriceController {
	
	@Autowired
	PriceRepository priceRepository; 
	
	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.POST)
	public Price save(@RequestParam("data") String data) throws IOException {
		Price foundPrice = (Price) Build.build(data,Price.class);
        return priceRepository.save(foundPrice);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Price> getAll(Pageable page) {
		return priceRepository.findAll(page);
	}
	
}
