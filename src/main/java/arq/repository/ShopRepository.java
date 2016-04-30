package arq.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import arq.domain.Shop;
import arq.repository.rest.AbstractRestRepository;

@NoRepositoryBean
public interface ShopRepository extends AbstractRestRepository<Shop, Long> {

	List<Shop> findById(long id);
	
}
