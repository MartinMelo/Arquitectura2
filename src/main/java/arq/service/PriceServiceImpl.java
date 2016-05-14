package arq.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arq.domain.Price;
import arq.dto.PriceDTO;

@Service("priceServiceImpl")
@Transactional(readOnly = true)
public class PriceServiceImpl implements PriceService {

	@Override
	public Price update(PriceDTO price, Price foundPrice) {
		if(price.getPrice() != foundPrice.getPrice()){
			foundPrice.setPrice(price.getPrice());
		}
		return foundPrice;
	}

}
