package dev.crowell.instantmessageservice.dtos;

import dev.crowell.instantmessageservice.entities.InstantMessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.rest.core.config.Projection;

import java.time.Duration;
import java.time.LocalDateTime;

@Projection(name = "messageDto", types = {InstantMessageEntity.class})
public interface InstantMessageDto {
    String getMessage();
}
