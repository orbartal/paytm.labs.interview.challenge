package paytm.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"paytm"})
@EntityScan(basePackages = {"paytm"})
@ComponentScan(basePackages = {"paytm"})
public class PaytmMain {
    public static void main(String[] args) {
    	System.out.println("PaytmMain");
        SpringApplication.run(PaytmMain.class, args);
    }
}
