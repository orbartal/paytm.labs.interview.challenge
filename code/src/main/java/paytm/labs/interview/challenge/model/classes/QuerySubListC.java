package paytm.labs.interview.challenge.model.classes;
import paytm.labs.interview.challenge.model.interfaces.QuerySubListI;

public class QuerySubListC implements QuerySubListI{
	
	protected long m_start = 0; 
	protected int m_size = 0;
	
	public QuerySubListC (int start, int size) {
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
