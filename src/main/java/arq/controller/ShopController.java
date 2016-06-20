package arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import arq.domain.Price;
import arq.domain.Shop;
import arq.pagination.domain.OffsetBasedPageRequest;
import arq.pagination.domain.Page;
import arq.pagination.service.PageService;
import arq.repository.ShopRepository;
import arq.service.exception.MarketRuntimeException;

/**
 * Created by Martin Alejandro on 4/11/2016.
 */
@RestController
@RequestMapping("${rest.base_path}/shops")
public class ShopController {
	
	@Autowired
	PageService<Shop> pageService;
	
    @Autowired
    ShopRepository shopRepository;
    
    @Value("${rest.base_path}")
    String rest;
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
	@Transactional(readOnly = false)
    public ResponseEntity<Shop> save(@RequestBody Shop shop, UriComponentsBuilder builder) {
        Shop aShop = null;
    	Pageable pageable = new OffsetBasedPageRequest(0, 20);
        
    	org.springframework.data.domain.Page<Shop> shops = shopRepository.findByNameAndAddressAndLocation(shop.getName(), shop.getAddress(), shop.getLocation(), pageable);
        if(shops.hasContent()){
        	throw new MarketRuntimeException("", "Ya existe un Shop con estas características");
        }else{
        	aShop = shopRepository.save(shop);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path(rest + "/shops/{id}").buildAndExpand(aShop.getId()).toUri());
        return new ResponseEntity<Shop>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.GET)
	@Transactional(readOnly = true)
    public Page<Shop> getAll(@RequestParam(required=false, value="offset") Integer offset,
    		@RequestParam(required=false, value="limit") Integer limit,
    		@RequestParam(required=false, value="name") String name,
		    @RequestParam(required=false, value="location") String location,
		    @RequestParam(required=false, value="address") String address,
		    @RequestParam(required=false, value="latitude") Double latitude,
		    @RequestParam(required=false, value="longitude") Double longitude) {
    	offset = offset == null ? 0 : offset;
		limit = limit == null ? 20 : limit;
		Pageable pageable = new OffsetBasedPageRequest(offset, limit);
    	if(name != null && address != null && location != null && latitude != null && longitude != null){
    		return pageService.createPage(shopRepository.findByNameAndAddressAndLocationAndLatitudeAndLongitude(
    				name, address, location, latitude, longitude, pageable), offset);
    	}
    	if(name != null && address != null && location != null){
    		return pageService.createPage(shopRepository.findByNameAndAddressAndLocation(name, address, location, pageable), offset);
    	}
    	if(name != null && address != null){
    		return pageService.createPage(shopRepository.findByNameAndAddress(name, address, pageable), offset);
    	}
    	if(name != null && location != null){
    		return pageService.createPage(shopRepository.findByNameAndLocation(name, location, pageable), offset);
    	}
    	if(latitude != null && longitude != null){
    		return pageService.createPage(shopRepository.findByLatitudeAndLongitude(latitude, longitude, pageable), offset);
    	}
    	if(name != null){
    		return pageService.createPage(shopRepository.findByName(name, pageable), offset);
    	}
        return pageService.createPage(shopRepository.findAll(pageable), offset);
    }
    
}
