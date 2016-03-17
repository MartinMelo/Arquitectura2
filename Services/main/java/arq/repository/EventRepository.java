package arq.repository;

import org.springframework.data.repository.NoRepositoryBean;

import arq.domain.Event;
import arq.repository.rest.AbstractRestRepository;

@NoRepositoryBean
public interface EventRepository extends AbstractRestRepository<Event, Long> {

}
