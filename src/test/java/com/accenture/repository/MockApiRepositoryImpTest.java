package com.accenture.repository;

import com.accenture.model.*;
import com.accenture.repository.MockApiRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MockApiRepositoryImpTest {

    private MockApiRepositoryImp mockApiRepositoryImpUnderTest;

    @BeforeEach
    void setUp() {
        mockApiRepositoryImpUnderTest = new MockApiRepositoryImp();
    }

    @Test
    void testCreateFinance() {
        // Setup
        final FinancialAccountCreateEvent expectedResult = new FinancialAccountCreateEvent();
        expectedResult.setId("f32b80a6-af3b-433a-8e6a-5dca7aedc8ef");
        expectedResult.setHref("href");
        expectedResult.setEventId("ed108579-3597-474c-a3b1-44904eef23b4");
        expectedResult.setEventTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        expectedResult.setEventType("eventType");
        expectedResult.setCorrelationId("e6fcacbc-fbce-423c-bb12-cd8f10849133");
        expectedResult.setDomain("domain");
        expectedResult.setTitle("title");
        expectedResult.setDescription("description");
        expectedResult.setPriority("priority");
        expectedResult.setTimeOcurred(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        final FinancialAccountCreateEventPayload payload = new FinancialAccountCreateEventPayload();
        final FinancialAccount financialAccount = new FinancialAccount();
        financialAccount.setId("ec2723e8-5159-45e5-904d-310146c356b5");
        financialAccount.setHref("href");
        financialAccount.setAccountType("accountType");
        financialAccount.setDescription("description");
        financialAccount.setLastModified(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        financialAccount.setName("name");
        financialAccount.setState("state");
        final AccountBalance accountBalance = new AccountBalance();
        accountBalance.setBalanceType("balanceType");
        final Money amount = new Money();
        amount.setUnit("unit");
        amount.setValue(0.0f);
        accountBalance.setAmount(amount);
        final TimePeriod validFor = new TimePeriod();
        validFor.setEndDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        validFor.setStartDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        accountBalance.setValidFor(validFor);
        accountBalance.setBaseType("baseType");
        accountBalance.setSchemaLocation("schemaLocation");
        accountBalance.setType("type");
        financialAccount.setAccountBalance(List.of(accountBalance));
        final AccountRelationship accountRelationship = new AccountRelationship();
        accountRelationship.setRelationshipType("relationshipType");
        final AccountRef account = new AccountRef();
        account.setId("f4c34f52-2689-4f39-9626-43dd10ee65d2");
        account.setHref("href");
        account.setDescription("description");
        account.setName("name");
        account.setBaseType("baseType");
        account.setSchemaLocation("schemaLocation");
        account.setType("type");
        account.setReferredType("referredType");
        accountRelationship.setAccount(account);
        final TimePeriod validFor1 = new TimePeriod();
        validFor1.setEndDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        validFor1.setStartDateTime(OffsetDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0), ZoneOffset.UTC));
        accountRelationship.setValidFor(validFor1);
        accountRelationship.setBaseType("baseType");
        accountRelationship.setSchemaLocation("schemaLocation");
        accountRelationship.setType("type");
        financialAccount.setAccountRelationship(List.of(accountRelationship));
        final Contact contact = new Contact();
        contact.setContactName("contactName");
        contact.setContactType("contactType");
        contact.setPartyRoleType("partyRoleType");
        final ContactMedium contactMedium = new ContactMedium();
        contactMedium.setMediumType("mediumType");
        contactMedium.setPreferred(false);
        final MediumCharacteristic characteristic = new MediumCharacteristic();
        characteristic.setCity("city");
        characteristic.setContactType("contactType");
        characteristic.setCountry("country");
        characteristic.setEmailAddress("emailAddress");
        characteristic.setFaxNumber("faxNumber");
        characteristic.setPhoneNumber("phoneNumber");
        characteristic.setPostCode("postCode");
        characteristic.setSocialNetworkId("a41294a6-84fe-4abf-bed5-36ccfa29856a");
        characteristic.setStateOrProvince("stateOrProvince");
        characteristic.setStreet1("street1");
        characteristic.setStreet2("street2");
        characteristic.setBaseType("baseType");
        characteristic.setSchemaLocation("schemaLocation");
        characteristic.setType("type");
        contactMedium.setCharacteristic(characteristic);
        contact.setContactMedium(List.of(contactMedium));
        financialAccount.setContact(List.of(contact));
        payload.setFinancialAccount(financialAccount);
        expectedResult.setPayload(payload);

        // Run the test
        final FinancialAccountCreateEvent result = mockApiRepositoryImpUnderTest.createFinance();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
