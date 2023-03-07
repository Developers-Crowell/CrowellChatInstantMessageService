package dev.crowell.instantmessageservice.controllers;

import dev.crowell.instantmessageservice.dtos.InstantMessageDto;
import dev.crowell.instantmessageservice.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/messages")
@Slf4j
@RequiredArgsConstructor
public class InstantMessageController {
    private final MessageService messageService;

    @GetMapping
    public Flux<InstantMessageDto> getAllMessages(@RequestParam(required = false) Sort sort) {
        return messageService.getAllMessages(Objects.requireNonNullElseGet(sort, () -> Sort.by(Sort.Direction.DESC, "id")));
    }
}
