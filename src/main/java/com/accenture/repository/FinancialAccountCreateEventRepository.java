package com.accenture.repository;

import com.accenture.model.FinancialAccountCreateEvent;

public interface FinancialAccountCreateEventRepository {
    FinancialAccountCreateEvent createFinanceAccount(FinancialAccountCreateEvent financialAccountCreateEvent);
}
