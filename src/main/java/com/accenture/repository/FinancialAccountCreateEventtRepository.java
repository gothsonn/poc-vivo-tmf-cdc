package com.accenture.repository;

import com.accenture.model.FinancialAccountCreateEvent;

public interface FinancialAccountCreateEventtRepository {
    FinancialAccountCreateEvent createFinanceAccount(FinancialAccountCreateEvent financialAccountCreateEvent);
}
