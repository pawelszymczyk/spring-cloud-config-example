package pl.pawel;

public class ApplicationPropertiesHolder {

    private final ApplicationProperties applicationProperties;

    public ApplicationPropertiesHolder(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }
}
