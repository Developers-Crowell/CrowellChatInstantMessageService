package dev.crowell.instantmessageservice.config;

import dev.crowell.instantmessageservice.handlers.InstantMessageEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
    public RepositoryConfiguration() {
        super();
    }

    @Bean
    InstantMessageEventHandler instantMessageEventHandler() {
        return new InstantMessageEventHandler();
    }
}
