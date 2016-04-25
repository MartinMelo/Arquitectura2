package arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import arq.domain.Price;
import arq.repository.PriceRepository;

@RestController
@RequestMapping("${rest.base_path}/found-prices")
public class PriceController {
	
	@Autowired
	PriceRepository priceRepository; 
	
	@RequestMapping(method = RequestMethod.POST)
	public Price save(@RequestBody Price price) {
		Price foundPrice = new Price();
		foundPrice.setDatetime(price.getDatetime());
		foundPrice.setPrice(price.getPrice());
		foundPrice.setProduct_id(price.getProduct_id());
		//agregar logica para setear el shop
		return priceRepository.save(foundPrice);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Price> getAll(Pageable page) {
		return priceRepository.findAll(page);
	}
	
}
