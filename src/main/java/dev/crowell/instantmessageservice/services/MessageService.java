package dev.crowell.instantmessageservice.services;

import dev.crowell.instantmessageservice.dtos.InstantMessageDto;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;

public interface MessageService {
    Flux<InstantMessageDto> getAllMessages(Sort sort);
}
