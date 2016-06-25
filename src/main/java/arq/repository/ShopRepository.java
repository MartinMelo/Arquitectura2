package arq.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import arq.domain.Shop;

@Cacheable(value = "shops", cacheManager = "springCM")
@NoRepositoryBean
public interface ShopRepository extends MongoRepository<Shop, String> {

	Page<Shop> findById(String id, Pageable pageable);
	
	Page<Shop> findByName(String name, Pageable pageable);
	
	Page<Shop> findByNameAndAddress(String name, String address, Pageable pageable);
	
	Page<Shop> findByNameAndLocation(String name, String location, Pageable pageable);
	
	Page<Shop> findByLatitudeAndLongitude(double latitude, double longitude, Pageable pageable);
	
	Page<Shop> findByNameAndAddressAndLocation(String name, String address, String location, Pageable pageable);
	
	Page<Shop> findByNameAndAddressAndLocationAndLatitudeAndLongitude(
			String name, String address, String location, double latitude, double longitude, Pageable pageable);
	
}
