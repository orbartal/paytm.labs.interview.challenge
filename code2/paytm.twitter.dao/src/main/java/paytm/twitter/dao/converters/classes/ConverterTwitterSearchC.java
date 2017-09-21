package paytm.twitter.dao.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.internal.model.classes.SearchTweetLEC;
import paytm.internal.model.interfaces.SearchTweetLEI;
import twitter4j.Status;

public class ConverterTwitterSearchC implements Converter <Status, SearchTweetLEI>{
	public SearchTweetLEI convert(Status status) {
		String s = "@" + status.getUser().getScreenName() + ":" + status.getText();
		return new SearchTweetLEC(s);
	}
}