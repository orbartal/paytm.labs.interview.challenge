package paytm.labs.interview.challenge.external.twitter.converters.classes;

import org.springframework.core.convert.converter.Converter;

import paytm.labs.interview.challenge.internal.model.classes.SearchTweetLEC;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchTweetLEI;
import twitter4j.Status;

public class ConverterTwitterSearchC implements Converter <Status, SearchTweetLEI>{
	public SearchTweetLEI convert(Status status) {
		String s = "@" + status.getUser().getScreenName() + ":" + status.getText();
		return new SearchTweetLEC(s);
	}
}