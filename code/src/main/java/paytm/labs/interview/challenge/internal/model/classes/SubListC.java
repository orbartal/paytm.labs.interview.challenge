package paytm.labs.interview.challenge.internal.model.classes;

import java.util.List;

import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListI;


public class SubListC<T> implements SubListI<T> {
	
	protected List<T> m_lstContent = null;
	protected long m_total = 0;
	protected QuerySubListI m_query = null;
	
	public SubListC (List<T> lstContent, long total, QuerySubListI query) {
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

	public QuerySubListI getQuerySubList() {
		return m_query;
	}

}
