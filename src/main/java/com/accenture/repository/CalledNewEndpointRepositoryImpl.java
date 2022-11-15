package com.accenture.repository;

import com.accenture.model.BillingAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Repository
public class CalledNewEndpointRepositoryImpl implements CalledNewEndpointRepository{

    private String endpointUri;
    private RestTemplate restTemplate;

    public CalledNewEndpointRepositoryImpl(
            RestTemplate restTemplate,
            @Value("${endpoint.calling.kafka}") String endpointUri
    ){
        this.restTemplate = restTemplate;
        this.endpointUri = endpointUri;
    }

    @Override
    public BillingAccount findById(BillingAccount billingAccount) {
        final URI url = UriComponentsBuilder.fromHttpUrl(this.endpointUri).build().toUri();
        log.debug(":: Called FinById {}", url);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<BillingAccount> requestHttpEntity = new HttpEntity<>(billingAccount, headers);
            ResponseEntity<BillingAccount> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestHttpEntity,
                    BillingAccount.class
            );
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Fail invocation Invoke to findById for {}", url, e);
            throw new Error("Fail invocation Invoke to findById for {}", e);
        }
    }
}
