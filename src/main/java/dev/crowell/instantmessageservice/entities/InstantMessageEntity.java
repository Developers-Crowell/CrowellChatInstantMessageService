package dev.crowell.instantmessageservice.entities;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "instant_messages")
@Slf4j
@Data
@Tag(name = "Instant Message Entity", description = "This is the entity that represents an instant message.")
public class InstantMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long senderId;
    private Long recipientId;
    private LocalDateTime createdTime;
    private LocalDateTime sentTime;
    private LocalDateTime receivedTime;
    private LocalDateTime readTime;
    private Long visibilityDuration;
    private Boolean isDeleted;
}
