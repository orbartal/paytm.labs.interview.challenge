package paytm.labs.interview.challenge.internal.model.interfaces;

import java.util.List;

public interface SubListLEI <T> {
	public List<T> getContent();
	public long getTotal();
	public QuerySubListLEI getQuerySubList();
}
