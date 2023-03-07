package dev.crowell.instantmessageservice.entities;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("instant_messages")
@Tag(name = "Instant Message Entity", description = "This is the entity that represents an instant message.")
public class InstantMessageEntity {
    @Id
    private Long id;
    private Long senderId;
    private Long recipientId;
    private Long duration;
    private LocalDateTime created;
    private LocalDateTime sent;
    private LocalDateTime received;
    private LocalDateTime delivered;
    private LocalDateTime read;
    private String message;
    private Boolean isDeleted;
    private Boolean hasDuration;
}
