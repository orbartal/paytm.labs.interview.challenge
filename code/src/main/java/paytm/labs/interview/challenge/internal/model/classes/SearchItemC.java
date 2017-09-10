package paytm.labs.interview.challenge.internal.model.classes;

import paytm.labs.interview.challenge.internal.model.interfaces.SearchItemI;

public class SearchItemC implements SearchItemI {
	protected String text;

	public SearchItemC(String s) {
		text = s;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}