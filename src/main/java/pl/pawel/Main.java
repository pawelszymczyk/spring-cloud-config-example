package pl.pawel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class Main {

    final static String environmentFromCommandLine = "test";

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLinePropertiesApplicationListener commandLinePropertiesApplicationListener() {
        return new CommandLinePropertiesApplicationListener();
    }

    @Bean
    ApplicationPropertiesHolder applicationPropertiesHolder(ApplicationProperties applicationProperties) {
        return new ApplicationPropertiesHolder(applicationProperties);
    }
}
