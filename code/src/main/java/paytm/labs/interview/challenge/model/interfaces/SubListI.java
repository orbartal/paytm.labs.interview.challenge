package paytm.labs.interview.challenge.model.interfaces;

import java.util.List;

public interface SubListI <T> {
	public List<T> getContent();
	public long getTotal();
	public QuerySubListI getQuerySubList();
}
