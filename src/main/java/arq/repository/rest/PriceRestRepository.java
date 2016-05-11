package arq.repository.rest;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import arq.repository.PriceRepository;

@RepositoryRestResource(path = "found-prices", collectionResourceRel = "found-prices")
public interface PriceRestRepository extends PriceRepository {
	
}
