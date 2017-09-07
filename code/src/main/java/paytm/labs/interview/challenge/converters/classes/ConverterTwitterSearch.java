package paytm.labs.interview.challenge.converters.classes;

import org.springframework.core.convert.converter.Converter;

import paytm.labs.interview.challenge.model.classes.SearchItemC;
import paytm.labs.interview.challenge.model.interfaces.SearchItemI;
import twitter4j.Status;

public class ConverterTwitterSearch implements Converter <Status, SearchItemI>{
	public SearchItemI convert(Status status) {
		String s = "@" + status.getUser().getScreenName() + ":" + status.getText();
		return new SearchItemC(s);
	}
}