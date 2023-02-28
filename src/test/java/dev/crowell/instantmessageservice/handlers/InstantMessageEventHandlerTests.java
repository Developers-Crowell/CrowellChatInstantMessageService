package dev.crowell.instantmessageservice.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.crowell.instantmessageservice.entities.InstantMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class InstantMessageEventHandlerTests {
    @Autowired
    private WebApplicationContext context;
    @SpyBean
    private InstantMessageEventHandler handler;
    private MockMvc mockMvc;

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

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void testHandleBeforeCreatedCalledWhenPostRequestSubmittedToMessagesEndpoint() {

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/messages")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(new InstantMessageEntity())))
                    .andExpect(MockMvcResultMatchers.status().isCreated());

            Mockito.verify(handler, Mockito.times(1)).handleBeforeCreate(any(InstantMessageEntity.class));
        } catch (Exception e) {
            Assertions.fail("Error: " + e.getMessage());
        }
    }

    @Test
    void testHandleAfterCreatedCalledWhenPostRequestSubmittedToMessagesEndpoint() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/messages")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(new InstantMessageEntity())))
                    .andExpect(MockMvcResultMatchers.status().isCreated());

            Mockito.verify(handler, Mockito.times(1)).handleAfterCreate(any(InstantMessageEntity.class));
        } catch (Exception e) {
            Assertions.fail("Error: " + e.getMessage());
        }
    }
}
