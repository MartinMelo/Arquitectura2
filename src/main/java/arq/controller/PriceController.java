package arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import arq.domain.Price;
import arq.domain.Shop;
import arq.dto.PriceDTO;
import arq.pagination.domain.OffsetBasedPageRequest;
import arq.pagination.service.PageService;
import arq.repository.PriceRepository;
import arq.repository.ShopRepository;
import arq.repository.rest.PriceRestRepository;
import arq.service.PriceService;
import arq.service.exception.MarketRuntimeException;

@RestController
@RequestMapping("${rest.base_path}/found-prices")
public class PriceController {
	
	@Autowired
	PageService<Price> pageService;
	
	@Autowired
	PriceRepository priceRepository; 
	
	@Autowired 
	PriceService priceService;
	
	@Autowired
	PriceRestRepository priceRestRepository;
	
	@Autowired
	ShopRepository shopRepository;
	
	@Value("${rest.base_path}")
    String rest;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Price> save(@RequestBody PriceDTO price, UriComponentsBuilder builder) {
		if(price.getShop_id() == null){
			throw new MarketRuntimeException("", "No se puede crear un found price sin su shop");
		}
		Pageable pageable = new OffsetBasedPageRequest(0, 20);
		Price foundPrice = null;
		Page<Price> oldPrices = priceRepository.findByProduct_idAndShop_idAndDatetime(price.getProduct_id(), price.getShop_id(), price.getDatetime(), pageable);
		if(oldPrices.hasContent()){
			foundPrice = oldPrices.getContent().get(0);
			foundPrice = priceService.update(price, foundPrice);
		}else{
			foundPrice = new Price();
			foundPrice.setDatetime(price.getDatetime());
			foundPrice.setPrice(price.getPrice());
			foundPrice.setProduct_id(price.getProduct_id());
			
			Page<Shop> shops = shopRepository.findById(price.getShop_id(), pageable);
			if(shops.hasContent()){
				foundPrice.setShop(shops.getContent().get(0));
			}
		}
		foundPrice = priceRepository.save(foundPrice);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path(rest + "/found-proces/{id}").buildAndExpand(foundPrice.getId()).toUri());
        return new ResponseEntity<Price>(headers, HttpStatus.CREATED);
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
