package com.accenture.api.synchronizer;

import com.accenture.model.BillingAccount;
import com.accenture.model.BillingAccountCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CdcSynchronizer {

    public CdcSynchronizer() {
    }

    @Scheduled(fixedDelay = 1000)
    public void synchronize(BillingAccountCreate message) {
        log.info("about to run the sync...");

//        1 get no endpoint criado la no proprst
//        2 modelar os dado de BillingAccountCreate para BillingAccount
//        3 var data = objectMapper.convertValue(billingAccount, BillingAccount.class);
//        4 data.setId("UUID");
//        5  fazer a chamada tipo post para o endpoint o fica o producer(rafael vai me passa juntamento com payload)

        log.info("finishing scheduled... ");
    }
}

