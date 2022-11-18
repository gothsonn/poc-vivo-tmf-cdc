package com.accenture.synchronizer;

import com.accenture.model.FinancialAccountCreateEvent;
import com.accenture.repository.FinancialAccountCreateEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@Slf4j
public class CdcSynchronizer {

    @Value("${endpoint.financial.account.create.event.mock}")
    private String urlCdc;
    private RestTemplate restTemplate;
    @Autowired
    private FinancialAccountCreateEventRepository calledNewEndpoint;

    public CdcSynchronizer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedDelay = 45000)
    public void synchronize() {
        log.info("About to run the sync...");
        
        final URI url = UriComponentsBuilder.fromHttpUrl(urlCdc).build().toUri();
        FinancialAccountCreateEvent financialAccountCreateEvent = new FinancialAccountCreateEvent();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<FinancialAccountCreateEvent> requestHttpEntity = new HttpEntity<>( financialAccountCreateEvent, headers);
            ResponseEntity<FinancialAccountCreateEvent> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestHttpEntity,
                    FinancialAccountCreateEvent.class
            );

            calledNewEndpoint.createFinanceAccount(responseEntity.getBody());
            System.out.println(responseEntity.getBody());

        } catch (Exception e) {
            log.error("Fail invocation Invoke to synchronize for {}", url, e);
            throw new Error("Fail invocation Invoke to synchronize for {}", e);
        }

        log.info("finishing scheduled... ");
    }
}

