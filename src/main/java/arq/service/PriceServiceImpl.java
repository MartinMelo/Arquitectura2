package arq.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arq.domain.Price;
import arq.domain.TypeCapability;
import arq.domain.TypeContainer;
import arq.dto.PriceDTO;
import arq.dto.PriceDetailDTO;

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

	@Override
	public Price updateDetails(Price foundPrice, PriceDetailDTO price) {
		if(price.getAmount() != null){
			foundPrice.setAmount(price.getAmount());
		}
		if(price.getBrand() != null){
			foundPrice.setBrand(price.getBrand());		
		}
		if(price.getType_of_capability() != null){
			foundPrice.setTypeCapability(TypeCapability.valueOf(price.getType_of_capability().toUpperCase()));
		}
		if(price.getType_of_container() != null){
			foundPrice.setTypeContainer(TypeContainer.valueOf(price.getType_of_container().toUpperCase()));
		}
		return foundPrice;
	}

}
