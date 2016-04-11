package arq.repository;

import org.springframework.data.repository.NoRepositoryBean;

import arq.domain.Shop;
import arq.repository.rest.AbstractRestRepository;

@NoRepositoryBean
public interface ShopRepository extends AbstractRestRepository<Shop, Long> {

}
