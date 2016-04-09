package arq.repository.rest;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import arq.repository.PrecioRepository;

@RepositoryRestResource(path = "precio", collectionResourceRel = "precio")
public interface PrecioRestRepository extends PrecioRepository {

}
