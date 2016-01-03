package pl.pawel;

import joptsimple.OptionParser;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.JOptCommandLinePropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Arrays;

import static pl.pawel.DefaultApplicationProperties.defaultProperties;

public class CommandLinePropertiesApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {

    private static final String ENVIRONMENT_PROPERTY = "application.environment";

    private static final String COMMAND_LINE_ARGS = "mySampleCommandLineArgs";

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
//        uncomment this and test should pass - don't listen to events in a bootstrap context
//        if (event.getEnvironment().getPropertySources().contains("bootstrapInProgress")) {
//            return;
//        }

        ConfigurableEnvironment environment = event.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(cmdLinePropertySource(event.getArgs()));
        propertySources.addLast(defaultProperties());

        String environmentName = environment.getProperty(ENVIRONMENT_PROPERTY);
        environment.addActiveProfile(environmentName);
    }

    private PropertySource<?> cmdLinePropertySource(String[] args) {
        OptionParser parser = new OptionParser();
        parser.acceptsAll(Arrays.asList(ENVIRONMENT_PROPERTY, "environment", "e")).withRequiredArg().defaultsTo("local");
        parser.allowsUnrecognizedOptions();
        return new JOptCommandLinePropertySource(COMMAND_LINE_ARGS, parser.parse(args));
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }


}

