package arq.controller;

import arq.domain.Shop;
import arq.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Martin Alejandro on 4/11/2016.
 */
@RestController
@RequestMapping("${rest.base_path}/shops")
public class ShopController {


    @Autowired
    ShopRepository shopRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Shop save(@RequestParam("name") String name, @RequestParam("name") String location) {
        Shop shop = new Shop();
        shop.setName(name);
        shop.setLocation(location);
        return shopRepository.save(shop);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Shop> getAll(Pageable page) {
        return shopRepository.findAll(page);
    }

}
