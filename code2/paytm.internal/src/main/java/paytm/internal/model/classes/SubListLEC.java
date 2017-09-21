package paytm.internal.model.classes;

import java.util.List;
import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SubListLEI;

public class SubListLEC<T> implements SubListLEI<T> {
	
	protected List<T> m_lstContent = null;
	protected long m_total = 0;
	protected QuerySubListLEI m_query = null;
	
	public SubListLEC (List<T> lstContent, long total, QuerySubListLEI query) {
		m_lstContent = lstContent;
		m_total = total;
		m_query = query;
	}
	public List<T> getContent() {
		return m_lstContent;
	}

	public long getTotal() {
		return m_total;
	}

	public QuerySubListLEI getQuerySubList() {
		return m_query;
	}
}