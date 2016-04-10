package arq.controller;

import java.util.Date;

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
	public Price save(@RequestParam("shop_id") String shop_id, @RequestParam("product_id") String product_id,
			@RequestParam("price") double price, @RequestParam("datetime") String datetime) {
		Price foundPrice = new Price();
		foundPrice.setDatetime(new Date(datetime));
		foundPrice.setPrice(price);
		foundPrice.setPruduct_id(product_id);
		//agregar logica para setear el shop
		return priceRepository.save(foundPrice);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Price> getAll(Pageable page) {
		return priceRepository.findAll(page);
	}
	
}
