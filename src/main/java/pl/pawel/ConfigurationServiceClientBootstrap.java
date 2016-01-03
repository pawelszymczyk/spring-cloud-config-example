package pl.pawel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ApplicationProperties.class})
public class ConfigurationServiceClientBootstrap {

    @Autowired
    ApplicationProperties properties;

    @Bean
    public ConfigurationServiceClient doSth() {
        //check only for tests
        if (!properties.getEnvironment().equals(Main.environmentFromCommandLine)) {
            throw new IllegalStateException("Environment from ApplicationProperties is different than environment passed through cmd, " +
                    "should be: " + Main.environmentFromCommandLine + " but was: " + properties.getEnvironment());
        }

        //do some stuff according to environment from ApplicationProperties
        return new ConfigurationServiceClient(properties.getEnvironment());
    }
}