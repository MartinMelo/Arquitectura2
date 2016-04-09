package arq.repository;

import org.springframework.data.repository.NoRepositoryBean;

import arq.domain.Precio;
import arq.repository.rest.AbstractRestRepository;

@NoRepositoryBean
public interface MercadoRepository extends AbstractRestRepository<Precio, Long> {

}
