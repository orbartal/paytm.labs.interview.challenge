package paytm.labs.interview.challenge.internal.model.interfaces;

import java.util.List;

public interface SubListI <T> {
	public List<T> getContent();
	public long getTotal();
	public QuerySubListI getQuerySubList();
}
