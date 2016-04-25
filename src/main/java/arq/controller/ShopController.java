package arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import arq.domain.Shop;
import arq.repository.ShopRepository;

/**
 * Created by Martin Alejandro on 4/11/2016.
 */
@RestController
@RequestMapping("${rest.base_path}/shops")
public class ShopController {


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
    public Page<Shop> getAll(Pageable page) {
        return shopRepository.findAll(page);
    }

}
