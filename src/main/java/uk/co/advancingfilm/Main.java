package uk.co.advancingfilm;

import uk.co.advancingfilm.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Main {

    public static final String NAMESPACE = "my-application";

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}