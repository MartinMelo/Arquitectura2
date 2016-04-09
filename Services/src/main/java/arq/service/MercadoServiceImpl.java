package arq.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mercadoServiceImpl")
@Transactional(readOnly = true)
public class MercadoServiceImpl implements MercadoService {

}
