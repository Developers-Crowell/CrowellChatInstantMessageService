package dev.crowell.instantmessageservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InstantMessageDto {
    private Long senderId;
    private Long recipientId;
    private Long duration;
    private LocalDateTime sent;
    private LocalDateTime delivered;
    private String message;
    private Boolean hasDuration;
}