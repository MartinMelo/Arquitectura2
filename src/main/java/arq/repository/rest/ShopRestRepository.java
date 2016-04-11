package arq.repository.rest;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import arq.repository.ShopRepository;

@RepositoryRestResource(path = "shops", collectionResourceRel = "shops")
public interface ShopRestRepository extends ShopRepository {


}
