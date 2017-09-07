package paytm.labs.interview.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.TwitterException;

@SpringBootApplication
public class PaytmLabsMain {

	public static void main(String[] args) throws TwitterException {
		SpringApplication.run(PaytmLabsMain.class, args);
	}
}