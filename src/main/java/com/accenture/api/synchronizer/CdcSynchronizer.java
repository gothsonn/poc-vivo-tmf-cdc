package com.accenture.api.synchronizer;

import com.accenture.model.BillingAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CdcSynchronizer {

    public CdcSynchronizer() {
    }

    public void synchronize(BillingAccount message) {
        log.info("about to run the sync...");
        PublishingMessage pus = new PublishingMessage();
        pus.executar(message);
        log.info("finishing scheduled... ");
    }
}

