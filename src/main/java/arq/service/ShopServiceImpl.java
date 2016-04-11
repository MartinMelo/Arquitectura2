package arq.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shopServiceImpl")
@Transactional(readOnly = true)
public class ShopServiceImpl implements ShopService {

}
