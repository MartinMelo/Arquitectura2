package arq.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arq.domain.Event;
import arq.repository.EventRepository;
import arq.repository.factory.EventFactory;

@Component
public class InitDatabase {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventFactory events;
	
    public void createData(){
    	events.create();
    	
    	List<Event> eventList = events.getEventAsList();
    	
    	eventRepository.save(eventList);
    }

}
