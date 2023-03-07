package dev.crowell.instantmessageservice.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class InstantMessageEventHandlerTests {
    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            if (!mapper.getRegisteredModuleIds().contains("com.fasterxml.jackson.datatype.jsr310.JavaTimeModule")) {
                log.info("Registering JavaTimeModule");
                mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            }
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}