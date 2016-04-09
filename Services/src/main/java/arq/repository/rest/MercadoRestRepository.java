package arq.repository.rest;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import arq.repository.MercadoRepository;

@RepositoryRestResource(path = "mercado", collectionResourceRel = "mercado")
public interface MercadoRestRepository extends MercadoRepository {

}
