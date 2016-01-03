package pl.pawel;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

public class DefaultApplicationProperties {

    public static final Map<String, Object> DEFAULT_PROPERTIES = new HashMap() {
        {
            put("application.environment", "local");
        }
    };

    public static PropertySource<?> defaultProperties() {
        return new MapPropertySource("beforeEnvironmentPreparedDefaults", DEFAULT_PROPERTIES);
    }
}
