package com.accenture.api;

import com.accenture.model.*;
import com.accenture.repository.FinancialAccountCreateEventRepository;
import com.accenture.repository.MockApiRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FinancialAccountApiController.class)
class FinancialAccountApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ObjectMapper mockObjectMapper;
    @MockBean
    private HttpServletRequest mockRequest;
    @MockBean
    private FinancialAccountCreateEventRepository mockCalledNewEndpoint;
    @MockBean
    private MockApiRepository mockMockApiRepository;

    @Test
    void testCreateFinancialAccount() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");

        // Configure ObjectMapper.convertValue(...).
        final FinancialAccount financialAccount = new FinancialAccount();
        financialAccount.setId("8365817a-cf92-43e2-b84b-ba46e7024c4c");
        financialAccount.setHref("href");
        financialAccount.setAccountType("accountType");
        financialAccount.setDescription("description");
        financialAccount.setLastModified(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        financialAccount.setName("name");
        financialAccount.setState("state");
        final AccountBalance accountBalance = new AccountBalance();
        accountBalance.setBalanceType("balanceType");
        final Money amount = new Money();
        amount.setUnit("unit");
        amount.setValue(0.0f);
        accountBalance.setAmount(amount);
        final TimePeriod validFor = new TimePeriod();
        validFor.setEndDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        validFor.setStartDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        accountBalance.setValidFor(validFor);
        financialAccount.setAccountBalance(List.of(accountBalance));
        when(mockObjectMapper.convertValue(new FinancialAccount(), FinancialAccount.class))
                .thenReturn(financialAccount);

        // Configure FinancialAccountCreateEventtRepository.createFinanceAccount(...).
        final FinancialAccountCreateEvent financialAccountCreateEvent = new FinancialAccountCreateEvent();
        financialAccountCreateEvent.setId("e26e1946-7d91-406b-bd9d-33156f9a2bbc");
        financialAccountCreateEvent.setHref("href");
        financialAccountCreateEvent.setEventId("eventId");
        financialAccountCreateEvent.setEventTime(
                OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        financialAccountCreateEvent.setEventType("eventType");
        financialAccountCreateEvent.setCorrelationId("33933d23-726e-4c30-8736-39c9853c8abc");
        financialAccountCreateEvent.setDomain("domain");
        financialAccountCreateEvent.setTitle("title");
        financialAccountCreateEvent.setDescription("description");
        financialAccountCreateEvent.setPriority("priority");
        financialAccountCreateEvent.setTimeOcurred(
                OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        final FinancialAccountCreateEventPayload payload = new FinancialAccountCreateEventPayload();
        final FinancialAccount financialAccount1 = new FinancialAccount();
        financialAccount1.setId("8365817a-cf92-43e2-b84b-ba46e7024c4c");
        financialAccount1.setHref("href");
        payload.setFinancialAccount(financialAccount1);
        financialAccountCreateEvent.setPayload(payload);
        when(mockCalledNewEndpoint.createFinanceAccount(new FinancialAccountCreateEvent()))
                .thenReturn(financialAccountCreateEvent);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/accountManagement/financialAccount")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockCalledNewEndpoint).createFinanceAccount(new FinancialAccountCreateEvent());
    }

    @Test

    void testCreateFinancialAccount_HttpServletRequestReturnsNull() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/accountManagement/financialAccount")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testCreateFinancialAccount_ObjectMapperThrowsIllegalArgumentException() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.convertValue(new FinancialAccount(), FinancialAccount.class))
                .thenThrow(IllegalArgumentException.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/accountManagement/financialAccount")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testCreateFinancial() throws Exception {
        // Setup
        // Configure MockApiRepository.createFinance(...).
        final FinancialAccountCreateEvent financialAccountCreateEvent = new FinancialAccountCreateEvent();
        financialAccountCreateEvent.setId("e26e1946-7d91-406b-bd9d-33156f9a2bbc");
        financialAccountCreateEvent.setHref("href");
        financialAccountCreateEvent.setEventId("eventId");
        financialAccountCreateEvent.setEventTime(
                OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        financialAccountCreateEvent.setEventType("eventType");
        financialAccountCreateEvent.setCorrelationId("33933d23-726e-4c30-8736-39c9853c8abc");
        financialAccountCreateEvent.setDomain("domain");
        financialAccountCreateEvent.setTitle("title");
        financialAccountCreateEvent.setDescription("description");
        financialAccountCreateEvent.setPriority("priority");
        financialAccountCreateEvent.setTimeOcurred(
                OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        final FinancialAccountCreateEventPayload payload = new FinancialAccountCreateEventPayload();
        final FinancialAccount financialAccount = new FinancialAccount();
        financialAccount.setId("8365817a-cf92-43e2-b84b-ba46e7024c4c");
        financialAccount.setHref("href");
        payload.setFinancialAccount(financialAccount);
        financialAccountCreateEvent.setPayload(payload);
        when(mockMockApiRepository.createFinance()).thenReturn(financialAccountCreateEvent);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/api")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeleteFinancialAccount() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                        delete("/accountManagement/financialAccount/{id}", "id")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testListFinancialAccount() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.readValue("{}", List.class)).thenReturn(List.of());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount")
                        .param("fields", "fields")
                        .param("offset", "0")
                        .param("limit", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testListFinancialAccount_HttpServletRequestReturnsNull() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount")
                        .param("fields", "fields")
                        .param("offset", "0")
                        .param("limit", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testListFinancialAccount_ObjectMapperReturnsNoItems() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.readValue("{}", List.class)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount")
                        .param("fields", "fields")
                        .param("offset", "0")
                        .param("limit", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testListFinancialAccount_ObjectMapperThrowsJsonProcessingException() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.readValue("{}", List.class)).thenThrow(JsonProcessingException.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount")
                        .param("fields", "fields")
                        .param("offset", "0")
                        .param("limit", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testListFinancialAccount_ObjectMapperThrowsJsonMappingException() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.readValue("{}", List.class)).thenThrow(JsonMappingException.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount")
                        .param("fields", "fields")
                        .param("offset", "0")
                        .param("limit", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPatchFinancialAccount() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");

        // Configure ObjectMapper.readValue(...).
        final FinancialAccount financialAccount = new FinancialAccount();
        financialAccount.setId("8365817a-cf92-43e2-b84b-ba46e7024c4c");
        financialAccount.setHref("href");
        financialAccount.setAccountType("accountType");
        financialAccount.setDescription("description");
        financialAccount.setLastModified(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        financialAccount.setName("name");
        financialAccount.setState("state");
        final AccountBalance accountBalance = new AccountBalance();
        accountBalance.setBalanceType("balanceType");
        final Money amount = new Money();
        amount.setUnit("unit");
        amount.setValue(0.0f);
        accountBalance.setAmount(amount);
        final TimePeriod validFor = new TimePeriod();
        validFor.setEndDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        validFor.setStartDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        accountBalance.setValidFor(validFor);
        financialAccount.setAccountBalance(List.of(accountBalance));
        when(mockObjectMapper.readValue("{\"empty\": false}", FinancialAccount.class)).thenReturn(financialAccount);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(patch("/accountManagement/financialAccount/{id}", "id")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPatchFinancialAccount_HttpServletRequestReturnsNull() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(patch("/accountManagement/financialAccount/{id}", "id")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPatchFinancialAccount_ObjectMapperThrowsJsonProcessingException() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.readValue("{\"empty\": false}", FinancialAccount.class))
                .thenThrow(JsonProcessingException.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(patch("/accountManagement/financialAccount/{id}", "id")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPatchFinancialAccount_ObjectMapperThrowsJsonMappingException() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.readValue("{\"empty\": false}", FinancialAccount.class))
                .thenThrow(JsonMappingException.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(patch("/accountManagement/financialAccount/{id}", "id")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testRetrieveFinancialAccount() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");

        // Configure ObjectMapper.readValue(...).
        final FinancialAccount financialAccount = new FinancialAccount();
        financialAccount.setId("8365817a-cf92-43e2-b84b-ba46e7024c4c");
        financialAccount.setHref("href");
        financialAccount.setAccountType("accountType");
        financialAccount.setDescription("description");
        financialAccount.setLastModified(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        financialAccount.setName("name");
        financialAccount.setState("state");
        final AccountBalance accountBalance = new AccountBalance();
        accountBalance.setBalanceType("balanceType");
        final Money amount = new Money();
        amount.setUnit("unit");
        amount.setValue(0.0f);
        accountBalance.setAmount(amount);
        final TimePeriod validFor = new TimePeriod();
        validFor.setEndDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        validFor.setStartDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        accountBalance.setValidFor(validFor);
        financialAccount.setAccountBalance(List.of(accountBalance));
        when(mockObjectMapper.readValue("{\"empty\": false}", FinancialAccount.class)).thenReturn(financialAccount);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount/{id}", "id")
                        .param("fields", "fields")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testRetrieveFinancialAccount_HttpServletRequestReturnsNull() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount/{id}", "id")
                        .param("fields", "fields")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testRetrieveFinancialAccount_ObjectMapperThrowsJsonProcessingException() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.readValue("{\"empty\": false}", FinancialAccount.class))
                .thenThrow(JsonProcessingException.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount/{id}", "id")
                        .param("fields", "fields")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testRetrieveFinancialAccount_ObjectMapperThrowsJsonMappingException() throws Exception {
        // Setup
        when(mockRequest.getHeader("Accept")).thenReturn("result");
        when(mockObjectMapper.readValue("{\"empty\": false}", FinancialAccount.class))
                .thenThrow(JsonMappingException.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/accountManagement/financialAccount/{id}", "id")
                        .param("fields", "fields")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
