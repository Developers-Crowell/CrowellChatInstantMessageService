package dev.crowell.instantmessageservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.crowell.instantmessageservice.repos.InstantMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InstantMessageServiceApplicationTests {
    @Autowired
    private InstantMessageRepository repository;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void contextLoads() {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(repository),
                () -> Assertions.assertNotNull(mapper)
        );
    }

}