package com.accenture.api;

import com.accenture.model.*;
import com.accenture.repository.FinancialAccountCreateEventRepository;
import com.accenture.repository.MockApiRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;


@RestController
public class FinancialAccountApiController implements FinancialAccountApi {

    private static final Logger log = LoggerFactory.getLogger(FinancialAccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final FinancialAccountCreateEventRepository calledNewEndpoint;

    private final MockApiRepository mockApiRepository;

    @Autowired
    public FinancialAccountApiController(
            ObjectMapper objectMapper,
            HttpServletRequest request,
            FinancialAccountCreateEventRepository calledNewEndpoint,
            MockApiRepository mockApiRepository
    ) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.calledNewEndpoint = calledNewEndpoint;
        this.mockApiRepository = mockApiRepository;
    }

    public ResponseEntity<FinancialAccountCreateEvent> createFinancialAccount(
            @ApiParam(value = "The FinancialAccount to be created" , required=true )
            @Valid @RequestBody FinancialAccount financialAccount
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            FinancialAccountCreateEvent financialAccountCreateEvent = new FinancialAccountCreateEvent();
            FinancialAccountCreateEventPayload financialAccountCreateEventPayload = new FinancialAccountCreateEventPayload();
            var financialAccountConvert = objectMapper.convertValue(financialAccount, FinancialAccount.class);
            OffsetDateTime offsetDateTime = OffsetDateTime.now();

            financialAccountConvert.setId(UUID.randomUUID().toString());
            financialAccountConvert.setHref("finalcialAccount");
            financialAccountCreateEventPayload.setFinancialAccount(financialAccountConvert);

            financialAccountCreateEvent.setId(UUID.randomUUID().toString());
            financialAccountCreateEvent.setHref("href");
            financialAccountCreateEvent.setEventId("eventId");
            financialAccountCreateEvent.setEventTime(offsetDateTime);
            financialAccountCreateEvent.setEventType("eventType");
            financialAccountCreateEvent.setCorrelationId(UUID.randomUUID().toString());
            financialAccountCreateEvent.setDomain("string");
            financialAccountCreateEvent.setTitle("string");
            financialAccountCreateEvent.setDescription("string");
            financialAccountCreateEvent.setPriority("string");
            financialAccountCreateEvent.setTimeOcurred(offsetDateTime);
            financialAccountCreateEvent.setPayload(financialAccountCreateEventPayload);


            calledNewEndpoint.createFinanceAccount(financialAccountCreateEvent);

            return new ResponseEntity<FinancialAccountCreateEvent>(financialAccountCreateEvent, HttpStatus.CREATED);
        }
        return new ResponseEntity<FinancialAccountCreateEvent>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<FinancialAccountCreateEvent> createFinancial() {

        var financialAccountCreateEvent = mockApiRepository.createFinance();

        return new ResponseEntity<FinancialAccountCreateEvent>(financialAccountCreateEvent, HttpStatus.OK);
    }


    public ResponseEntity<FinancialAccount> retrieveFinancialAccount(
            @ApiParam(value = "Identifier of the FinancialAccount",required=true)
            @PathVariable("id") String id,
            @ApiParam(value = "Comma-separated properties to provide in response")
            @Valid @RequestParam(value = "fields", required = false) String fields
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<FinancialAccount>(objectMapper.readValue("{\"empty\": false}", FinancialAccount.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FinancialAccount>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<FinancialAccount>(HttpStatus.NOT_IMPLEMENTED);
    }

}
