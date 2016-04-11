package arq.controller;

import arq.domain.Shop;
import arq.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Martin Alejandro on 4/11/2016.
 */
@RestController
@RequestMapping("${rest.base_path}/shops")
public class ShopController {


    @Autowired
    ShopRepository shopRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Shop> save(@RequestParam("name") String name) {
        return shopRepository.findAll();
    }

}
