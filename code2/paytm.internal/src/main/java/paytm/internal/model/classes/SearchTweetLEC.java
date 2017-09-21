package paytm.internal.model.classes;

import paytm.internal.model.interfaces.SearchTweetLEI;

public class SearchTweetLEC implements SearchTweetLEI {
	protected String text;

	public SearchTweetLEC(String s) {
		text = s;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
