package arq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import arq.domain.Price;
import arq.domain.Shop;
import arq.dto.PriceDTO;
import arq.pagination.domain.OffsetBasedPageRequest;
import arq.pagination.service.PageService;
import arq.repository.PriceRepository;
import arq.repository.ShopRepository;
import arq.repository.rest.PriceRestRepository;

@RestController
@RequestMapping("${rest.base_path}/found-prices")
public class PriceController {
	
	@Autowired
	PageService<Price> pageService;
	
	@Autowired
	PriceRepository priceRepository; 
	
	@Autowired
	PriceRestRepository priceRestRepository;
	
	@Autowired
	ShopRepository shopRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public Price save(@RequestBody PriceDTO price) {
		Price foundPrice = new Price();
		foundPrice.setDatetime(price.getDatetime());
		foundPrice.setPrice(price.getPrice());
		foundPrice.setProduct_id(price.getProduct_id());
		List<Shop> shops = shopRepository.findById(price.getShop_id());
		if(shops.get(0) != null){
			foundPrice.setShop(shops.get(0));
		}
		return priceRepository.save(foundPrice);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public arq.pagination.domain.Page<Price> getAll(@RequestParam(required=false, value="offset") Integer offset,
    		@RequestParam(required=false, value="limit") Integer limit,
    		@RequestParam(required=false, value="price") Double price,
    		@RequestParam(required=false, value="product_id") String product_id) {
		System.out.println(price);
		System.out.println(product_id);
		if(offset == null && limit == null){
    		Pageable pageable = new PageRequest(0, 20);
            return pageService.createPage(priceRepository.findAll(pageable), offset);
    	}else{
    		if(offset == null){
    			offset = 0;
    		}
    		if(limit == null){
    			limit = 20; 
    		}
    	}
    	Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return pageService.createPage(priceRepository.findAll(pageable), offset);
	}
	
}
