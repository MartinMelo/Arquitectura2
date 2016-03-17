package arq.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("eventServiceImpl")
@Transactional(readOnly = true)
public class EventServiceImpl implements EventService {

}
