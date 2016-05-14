package arq.service;

import arq.domain.Price;
import arq.dto.PriceDTO;

public interface PriceService {

	Price update(PriceDTO price, Price foundPrice);

}
