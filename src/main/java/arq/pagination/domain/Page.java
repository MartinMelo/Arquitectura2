package arq.pagination.domain;

import java.util.List;

public class Page<T> {
	
	List<T> items;
	
    Paging paging;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
