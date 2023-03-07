package dev.crowell.instantmessageservice.services;

import dev.crowell.instantmessageservice.dtos.InstantMessageDto;
import dev.crowell.instantmessageservice.repos.InstantMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final InstantMessageRepository instantMessageRepository;
    private final ModelMapper modelMapper;

    @Override
    public Flux<InstantMessageDto> getAllMessages(Sort sort) {
        log.info("Getting all messages");
        var messages = instantMessageRepository.findAll(sort);
        return messages.map(message -> modelMapper.map(message, InstantMessageDto.class));
    }
}
