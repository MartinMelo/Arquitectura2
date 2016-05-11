package arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
		
		Pageable pageable = new OffsetBasedPageRequest(0, 20);
		Page<Shop> shops = shopRepository.findById(price.getShop_id(), pageable);
		if(shops.getContent().get(0) != null){
			foundPrice.setShop(shops.getContent().get(0));
		}
		return priceRepository.save(foundPrice);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public arq.pagination.domain.Page<Price> getAll(@RequestParam(required=false, value="offset") Integer offset,
    		@RequestParam(required=false, value="limit") Integer limit,
    		@RequestParam(required=false, value="price") Double price,
    		@RequestParam(required=false, value="product_id") String product_id,
    		@RequestParam(required=false, value="shop") Long shop) {
		offset = offset == null ? 0 : offset;
		limit = limit == null ? 20 : limit;
		Pageable pageable = new OffsetBasedPageRequest(offset, limit);
		if(shop != null && product_id != null){
			return pageService.createPage(priceRepository.findByProduct_idAndShop(product_id, shop, pageable), offset);
		}
		if(shop != null && product_id == null){
			return pageService.createPage(priceRepository.findByShop(shop, pageable), offset);
		}
		if(shop == null && product_id != null){
			return pageService.createPage(priceRepository.findByProduct_id(product_id, pageable), offset);
		}
        return pageService.createPage(priceRepository.findAll(pageable), offset);
	}
	
}
