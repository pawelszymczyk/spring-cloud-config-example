package pl.pawel;

import org.junit.Test;
import org.springframework.boot.SpringApplication;

public class CommandLinePropertiesApplicationListenerTest {

    @Test
    public void shouldNotThrowsException() throws Throwable {
        String[] args = {
                "-e", Main.environmentFromCommandLine
        };

        SpringApplication.run(Main.class, args);
    }
}