package arq.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import arq.domain.Price;
import arq.repository.rest.AbstractRestRepository;

@NoRepositoryBean
public interface PriceRepository extends AbstractRestRepository<Price, Long> {
	
	List<Price> findById(long id);

	@Query("select p from Price p where p.product_id = ?1")
	Page<Price> findByProduct_id(String id, Pageable pageable);
	
	Page<Price> findByDatetime(Date date, Pageable pageable);
	
	@Query("select p from Price p where p.shop.id = ?1")
	Page<Price> findByShop(long id, Pageable pageable);
	
	@Query("select p from Price p where p.product_id = ?1 and p.shop.id = ?2")
	Page<Price> findByProduct_idAndShop(String id, long shop, Pageable pageable);
	
	@Query("select p from Price p where p.product_id = ?1 and p.shop.id = ?2 and p.datetime = ?3")
	Page<Price> findByProduct_idAndShop_idAndDatetime(String id, long shop, Date date, Pageable pageable);
	
}
