package arq.repository;

import org.springframework.data.repository.NoRepositoryBean;

import arq.domain.Price;
import arq.repository.rest.AbstractRestRepository;

@NoRepositoryBean
public interface PriceRepository extends AbstractRestRepository<Price, Long> {
	
}
