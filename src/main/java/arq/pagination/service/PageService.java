package arq.pagination.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arq.domain.Price;
import arq.pagination.domain.Page;
import arq.pagination.domain.Paging;

@Service("pageService")
@Transactional(readOnly = true)
public class PageService<T> {

	public Page<T> createPage(org.springframework.data.domain.Page<T> page, int offset) {
		Page<T> aPage = new Page<T>();
		Paging paging = new Paging();
		aPage.setItems(page.getContent());
		paging.setLimit(page.getSize());
		paging.setTotal(page.getTotalElements());
		paging.setOffset(offset);
		aPage.setPaging(paging);
		return aPage;
	}

}
