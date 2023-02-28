package dev.crowell.instantmessageservice.entities;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Entity
@Table(name = "instant_messages")
@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Instant Message Entity", description = "This is the entity that represents an instant message.")
public class InstantMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long senderId;
    private Long recipientId;
    private Long duration;
    private LocalDateTime create;
    private LocalDateTime sent;
    private LocalDateTime received;
    private LocalDateTime delivered;
    private LocalDateTime read;
    private String message;
    private Boolean isDeleted;
    private Boolean hasDuration;
}
