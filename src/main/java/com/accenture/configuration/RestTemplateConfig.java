package com.accenture.configuration;

import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;

@Configuration
public class RestTemplateConfig {

    @Bean
    @Primary
    public RestTemplate init() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionReuseStrategy(NoConnectionReuseStrategy.INSTANCE).build();
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        stringHttpMessageConverter.setWriteAcceptCharset(true);

        requestFactory.setHttpClient(httpClient);

        restTemplate.getMessageConverters().add(0, stringHttpMessageConverter);
        return restTemplate;
    }
}
