package dev.crowell.instantmessageservice.handlers;

import dev.crowell.instantmessageservice.entities.InstantMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
@Slf4j
public class InstantMessageEventHandler {
    @HandleBeforeCreate
    public void handleBeforeCreate(InstantMessageEntity message) {
        log.warn("Received request to create this instant message: {}", message);
    }

    @HandleAfterCreate
    public void handleAfterCreate(InstantMessageEntity message) {
        log.warn("Add message to queue to let other services know the following instant message has been created: {}", message);
    }
}
