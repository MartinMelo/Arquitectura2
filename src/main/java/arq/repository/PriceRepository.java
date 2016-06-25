package arq.repository;

import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import arq.domain.Price;

@Cacheable(value = "prices", cacheManager = "springCM")
@NoRepositoryBean
public interface PriceRepository extends MongoRepository<Price, String> {
	
	List<Price> findById(String id);

	Page<Price> findByProduct(String product, Pageable pageable);

	Page<Price> findByDatetime(Date date, Pageable pageable);
	
	Page<Price> findByShop(String id, Pageable pageable);

	Page<Price> findByProductAndShop(String product, String shop, Pageable pageable);

	Page<Price> findByProductAndShopAndDatetime(String product, String shop, Date date, Pageable pageable);

}
