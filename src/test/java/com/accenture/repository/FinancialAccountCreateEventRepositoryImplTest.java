package com.accenture.repository;

import com.accenture.api.FinancialAccountApiController;
import com.accenture.model.FinancialAccount;
import com.accenture.model.FinancialAccountCreateEvent;
import com.accenture.model.FinancialAccountCreateEventPayload;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = FinancialAccountApiController.class)
class FinancialAccountCreateEventRepositoryImplTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testCreateFinanceAccount() throws Exception {
        // Setup
        final FinancialAccountCreateEvent financialAccountCreateEvent = new FinancialAccountCreateEvent();
        financialAccountCreateEvent.setId(UUID.randomUUID().toString());
        financialAccountCreateEvent.setHref("href");
        financialAccountCreateEvent.setEventId("eventId");
        financialAccountCreateEvent.setEventTime(
                OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        financialAccountCreateEvent.setEventType("eventType");
        financialAccountCreateEvent.setCorrelationId("correlationId");
        financialAccountCreateEvent.setDomain("domain");
        financialAccountCreateEvent.setTitle("title");
        financialAccountCreateEvent.setDescription("description");
        financialAccountCreateEvent.setPriority("priority");
        financialAccountCreateEvent.setTimeOcurred(
                OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        final FinancialAccountCreateEventPayload payload = new FinancialAccountCreateEventPayload();
        final FinancialAccount financialAccount = new FinancialAccount();
        financialAccount.setId(UUID.randomUUID().toString());
        financialAccount.setHref("href");
        financialAccount.setAccountType("tipo de conta");
        financialAccount.setDescription("descricao");
        financialAccount.setLastModified(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        financialAccount.setName("nome");
        financialAccount.setState("estado");
        financialAccount.setBaseType("tipo de base");
        financialAccount.setSchemaLocation("localizxao de schema");
        financialAccount.setType("tiipo");
        payload.setFinancialAccount(financialAccount);
        financialAccountCreateEvent.setPayload(payload);

        final FinancialAccountCreateEvent expectedResult = new FinancialAccountCreateEvent();
        expectedResult.setId(UUID.randomUUID().toString());
        expectedResult.setHref("href");
        expectedResult.setEventId("eventId");
        expectedResult.setEventTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        expectedResult.setEventType("eventType");
        expectedResult.setCorrelationId("correlationId");
        expectedResult.setDomain("domain");
        expectedResult.setTitle("title");
        expectedResult.setDescription("description");
        expectedResult.setPriority("priority");
        expectedResult.setTimeOcurred(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));;
        expectedResult.setPayload(payload);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/accountManagement/api"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
