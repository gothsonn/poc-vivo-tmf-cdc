package com.accenture.repository;

import com.accenture.model.*;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository
public class MockApiRepositoryImp implements MockApiRepository {

    @Override
    public FinancialAccountCreateEvent createFinance() {

        AccountBalance accountBalance = new AccountBalance();
        AccountRef accountRef = new AccountRef();
        AccountRelationship accountRelationship = new AccountRelationship();
        AccountTaxExemption accountTaxExemption = new AccountTaxExemption();
        Contact contact = new Contact();
        ContactMedium contactMedium = new ContactMedium();
        FinancialAccount financialAccount = new FinancialAccount();
        FinancialAccountCreateEvent financialAccountCreateEvent = new FinancialAccountCreateEvent();
        FinancialAccountCreateEventPayload financialAccountCreateEventPayload = new FinancialAccountCreateEventPayload();
        MediumCharacteristic mediumCharacteristic = new MediumCharacteristic();
        Money money = new Money();
        RelatedParty relatedParty = new RelatedParty();
        TimePeriod timePeriod = new TimePeriod();

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        List<ContactMedium> listContactMedium = new ArrayList<ContactMedium>();
        List<AccountBalance> listAccountBalance = new ArrayList<AccountBalance>();
        List<AccountRelationship> listAccountRelationship = new ArrayList<AccountRelationship>();
        List<Contact> listContact = new ArrayList<Contact>();
        List<RelatedParty> listRelatedParty = new ArrayList<RelatedParty>();
        List<AccountTaxExemption> listAccountTaxExemption = new ArrayList<AccountTaxExemption>();


        mediumCharacteristic.setCity("Cidade");
        mediumCharacteristic.setBaseType("Tipo de Base");
        mediumCharacteristic.setContactType("Tipo de Contrato");
        mediumCharacteristic.setCountry("Pais");
        mediumCharacteristic.setEmailAddress("email ...");
        mediumCharacteristic.setFaxNumber("12121212");
        mediumCharacteristic.setPhoneNumber("09090909");
        mediumCharacteristic.setPostCode("5444342");
        mediumCharacteristic.setSchemaLocation("schema location");
        mediumCharacteristic.setSocialNetworkId(UUID.randomUUID().toString());
        mediumCharacteristic.setStateOrProvince("Estado ou provincia");
        mediumCharacteristic.setStreet1("Street numero 1");
        mediumCharacteristic.setStreet2("Rua numero 2");
        mediumCharacteristic.setType("So tipo");

        timePeriod.setEndDateTime(offsetDateTime);
        timePeriod.setStartDateTime(offsetDateTime);

        money.setUnit("Unidade");
        money.setValue(2000F);

        accountBalance.setBalanceType("Tipo do Balance");
        accountBalance.setBaseType("Tipo da base");
        accountBalance.setSchemaLocation("Localicao do Schema");
        accountBalance.setType("tipo do account Balance");
        accountBalance.setValidFor(timePeriod);
        accountBalance.setAmount(money);
        listAccountBalance.add(accountBalance);
        listAccountBalance.add(accountBalance);

        accountRef.setId(UUID.randomUUID().toString());
        accountRef.setHref("Hfer Acconte REF");
        accountRef.setDescription("Descricao");
        accountRef.setName("Nome do Ref");
        accountRef.setBaseType("TIpo de base");
        accountRef.setSchemaLocation("schema");
        accountRef.setType("tipo");
        accountRef.setReferredType("Refencia do tipo");

        accountRelationship.setRelationshipType("Relacao do Tipo");
        accountRelationship.setBaseType("tipo de base");
        accountRelationship.setSchemaLocation("schema");
        accountRelationship.setType("tipo");
        accountRelationship.setValidFor(timePeriod);
        accountRelationship.setAccount(accountRef);
        listAccountRelationship.add(accountRelationship);
        listAccountRelationship.add(accountRelationship);
        listAccountRelationship.add(accountRelationship);
        listAccountRelationship.add(accountRelationship);

        contactMedium.setMediumType("Tipo de Medium");
        contactMedium.setPreferred(true);
        contactMedium.setBaseType("tipo de base");
        contactMedium.setSchemaLocation("local schema");
        contactMedium.setType("tipo");
        contactMedium.setCharacteristic(mediumCharacteristic);
        contactMedium.setValidFor(timePeriod);
        listContactMedium.add(contactMedium);
        listContactMedium.add(contactMedium);
        listContactMedium.add(contactMedium);

        relatedParty.setId(UUID.randomUUID().toString());
        relatedParty.setHref("H ref");
        relatedParty.setName("nome rel");
        relatedParty.setRole("regra");
        relatedParty.setBaseType("tipo de base");
        relatedParty.setSchemaLocation("schema loca");
        relatedParty.setType("tipo");
        relatedParty.setReferredType("refe");
        listRelatedParty.add(relatedParty);
        listRelatedParty.add(relatedParty);

        contact.setContactName("Nome do contrat");
        contact.setContactType("tipo do contrato");
        contact.setPartyRoleType("Part de regra do tipo");
        contact.setBaseType("tipo do base");
        contact.setSchemaLocation("local shcema");
        contact.setType("tipo contact");
        contact.setContactMedium(listContactMedium);
        contact.setRelatedParty(relatedParty);
        contact.setValidFor(timePeriod);
        listContact.add(contact);
        listContact.add(contact);

        accountTaxExemption.setCertificateNumber("981");
        accountTaxExemption.setIssuingJurisdiction("Issue");
        accountTaxExemption.setReason("razao");
        accountTaxExemption.setBaseType("tipo de base");
        accountTaxExemption.setSchemaLocation("schema");
        accountTaxExemption.setType("tipo");
        accountTaxExemption.setValidFor(timePeriod);
        listAccountTaxExemption.add(accountTaxExemption);
        listAccountTaxExemption.add(accountTaxExemption);
        listAccountTaxExemption.add(accountTaxExemption);
        listAccountTaxExemption.add(accountTaxExemption);

        financialAccount.setId(UUID.randomUUID().toString());
        financialAccount.setHref("h ref");
        financialAccount.setAccountType("tipo de conta");
        financialAccount.setDescription("descricao");
        financialAccount.setLastModified(offsetDateTime);
        financialAccount.setName("nome");
        financialAccount.setState("estado");
        financialAccount.setAccountBalance(listAccountBalance);
        financialAccount.setAccountRelationship(listAccountRelationship);
        financialAccount.setContact(listContact);
        financialAccount.setCreditLimit(money);
        financialAccount.setRelatedParty(listRelatedParty);
        financialAccount.setTaxExemption(listAccountTaxExemption);
        financialAccount.setBaseType("tipo de base");
        financialAccount.setSchemaLocation("localizxao de schema");
        financialAccount.setType("tiipo");

        financialAccountCreateEventPayload.setFinancialAccount(financialAccount);

        financialAccountCreateEvent.setId(UUID.randomUUID().toString());
        financialAccountCreateEvent.setHref("ref H");
        financialAccountCreateEvent.setEventId(UUID.randomUUID().toString());
        financialAccountCreateEvent.setEventTime(offsetDateTime);
        financialAccountCreateEvent.setEventType("tipo de evento");
        financialAccountCreateEvent.setCorrelationId(UUID.randomUUID().toString());
        financialAccountCreateEvent.setDomain("dominio");
        financialAccountCreateEvent.setTitle("titulo");
        financialAccountCreateEvent.setDescription("descricao");
        financialAccountCreateEvent.setPriority("prioridade");
        financialAccountCreateEvent.setTimeOcurred(offsetDateTime);
        financialAccountCreateEvent.setPayload(financialAccountCreateEventPayload);

        return financialAccountCreateEvent;
    }
}
