package com.accenture.repository;


import com.accenture.model.FinancialAccountCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Repository
public class FinancialAccountCreateEventtRepositoryImpl implements FinancialAccountCreateEventtRepository {

    private String endpointUri;
    private RestTemplate restTemplate;

    public FinancialAccountCreateEventtRepositoryImpl(
            RestTemplate restTemplate,
            @Value("${endpoint.financial.account.create.event}") String endpointUri
    ){
        this.restTemplate = restTemplate;
        this.endpointUri = endpointUri;
    }

    @Override
    public FinancialAccountCreateEvent createFinanceAccount(FinancialAccountCreateEvent financialAccountCreateEvent) {
        final URI url = UriComponentsBuilder.fromHttpUrl(this.endpointUri).build().toUri();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<FinancialAccountCreateEvent> requestHttpEntity = new HttpEntity<>(financialAccountCreateEvent, headers);
            ResponseEntity<FinancialAccountCreateEvent> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestHttpEntity,
                    FinancialAccountCreateEvent.class
            );
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Fail invocation Invoke to FinancialAccountCreateEvent for {}", url, e);
            throw new Error("Fail invocation Invoke to FinancialAccountCreateEvent for {}", e);
        }
    }
}
