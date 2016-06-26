package arq.service;

import arq.domain.Price;
import arq.dto.PriceDTO;
import arq.dto.PriceDetailDTO;

public interface PriceService {

	Price update(PriceDTO price, Price foundPrice);

	Price updateDetails(Price foundPrice, PriceDetailDTO price);

}
