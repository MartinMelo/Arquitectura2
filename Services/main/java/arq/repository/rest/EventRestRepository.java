package arq.repository.rest;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import arq.repository.EventRepository;

@RepositoryRestResource(path = "event", collectionResourceRel = "event")
public interface EventRestRepository extends EventRepository {
	
}
