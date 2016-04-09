package arq.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("precioServiceImpl")
@Transactional(readOnly = true)
public class PrecioServiceImpl implements PrecioService {

}
