package arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import arq.domain.Shop;
import arq.pagination.domain.OffsetBasedPageRequest;
import arq.pagination.domain.Page;
import arq.pagination.service.PageService;
import arq.repository.ShopRepository;

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
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Shop> save(@RequestBody Shop shop, UriComponentsBuilder builder) {
        Shop aShop = shopRepository.save(shop);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/shops/{id}").buildAndExpand(aShop.getId()).toUri());
        return new ResponseEntity<Shop>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
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
    	System.out.println(name);
    	System.out.println(location);
    	System.out.println(address);
    	System.out.println(latitude);
    	System.out.println(longitude);
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
