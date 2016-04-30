package arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    		@RequestParam(required=false, value="limit") Integer limit) {
    	if(offset == null && limit == null){
    		Pageable pageable = new PageRequest(0, 20);
            return pageService.createPage(shopRepository.findAll(pageable));
    	}else{
    		if(offset == null){
    			offset = 0;
    		}
    		if(limit == null){
    			limit = 20; 
    		}
    	}
    	Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return pageService.createPage(shopRepository.findAll(pageable));
    }
    
}
