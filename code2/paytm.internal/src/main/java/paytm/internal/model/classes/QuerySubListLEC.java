package paytm.internal.model.classes;

import paytm.internal.model.interfaces.QuerySubListLEI;

public class QuerySubListLEC implements QuerySubListLEI{
	
	protected long m_start = 0; 
	protected int m_size = 0;
	
	public QuerySubListLEC (int start, int size) {
		m_start = start;
		m_size = size;
	}

	public long getStart() {
		return m_start;
	}

	public int getSize() {
		return m_size;
	}
	
}
