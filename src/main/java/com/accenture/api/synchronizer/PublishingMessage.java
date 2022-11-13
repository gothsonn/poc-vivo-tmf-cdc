package com.accenture.api.synchronizer;

import com.accenture.model.BillingAccount;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;

@Slf4j
public class PublishingMessage {
    private Producer<String, String> producer;

    public PublishingMessage() {
        producer = createProducer();
    }

    private Producer<String, String> createProducer() {
        if (producer != null) {
            return producer;
        }

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
        return new KafkaProducer<String, String>(properties);
    }

    public void executar(BillingAccount message) {
        String chave = UUID.randomUUID().toString();
        log.info("Start send message");
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("RegisterEvent", chave, message.toString());
        producer.send(record);
        producer.flush();
        producer.close();
        log.info("Send messagem success ::::: ", message);
    }
}
