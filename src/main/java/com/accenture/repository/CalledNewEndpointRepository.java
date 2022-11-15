package com.accenture.repository;

import com.accenture.model.BillingAccount;

public interface CalledNewEndpointRepository {
    BillingAccount findById(BillingAccount idBillingAccount);
}
