package com.accenture.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * The notification data structure
 */
@ApiModel(description = "The notification data structure")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T21:16:01.493Z")


public class SettlementAccountStateChangeEvent   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("eventId")
  private String eventId = null;

  @JsonProperty("eventTime")
  private OffsetDateTime eventTime = null;

  @JsonProperty("eventType")
  private String eventType = null;

  @JsonProperty("correlationId")
  private String correlationId = null;

  @JsonProperty("domain")
  private String domain = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("priority")
  private String priority = null;

  @JsonProperty("timeOcurred")
  private OffsetDateTime timeOcurred = null;

  @JsonProperty("payload")
  private SettlementAccountStateChangeEventPayload payload = null;

  public SettlementAccountStateChangeEvent id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the Process flow
   * @return id
  **/
  @ApiModelProperty(value = "Identifier of the Process flow")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SettlementAccountStateChangeEvent href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the ProcessFlow
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the ProcessFlow")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public SettlementAccountStateChangeEvent eventId(String eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * The identifier of the notification.
   * @return eventId
  **/
  @ApiModelProperty(value = "The identifier of the notification.")


  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public SettlementAccountStateChangeEvent eventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * Time of the event occurrence.
   * @return eventTime
  **/
  @ApiModelProperty(value = "Time of the event occurrence.")

  @Valid

  public OffsetDateTime getEventTime() {
    return eventTime;
  }

  public void setEventTime(OffsetDateTime eventTime) {
    this.eventTime = eventTime;
  }

  public SettlementAccountStateChangeEvent eventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * The type of the notification.
   * @return eventType
  **/
  @ApiModelProperty(value = "The type of the notification.")


  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public SettlementAccountStateChangeEvent correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * The correlation id for this event.
   * @return correlationId
  **/
  @ApiModelProperty(value = "The correlation id for this event.")


  public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public SettlementAccountStateChangeEvent domain(String domain) {
    this.domain = domain;
    return this;
  }

  /**
   * The domain of the event.
   * @return domain
  **/
  @ApiModelProperty(value = "The domain of the event.")


  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public SettlementAccountStateChangeEvent title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the event.
   * @return title
  **/
  @ApiModelProperty(value = "The title of the event.")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public SettlementAccountStateChangeEvent description(String description) {
    this.description = description;
    return this;
  }

  /**
   * An explnatory of the event.
   * @return description
  **/
  @ApiModelProperty(value = "An explnatory of the event.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SettlementAccountStateChangeEvent priority(String priority) {
    this.priority = priority;
    return this;
  }

  /**
   * A priority.
   * @return priority
  **/
  @ApiModelProperty(value = "A priority.")


  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public SettlementAccountStateChangeEvent timeOcurred(OffsetDateTime timeOcurred) {
    this.timeOcurred = timeOcurred;
    return this;
  }

  /**
   * The time the event occured.
   * @return timeOcurred
  **/
  @ApiModelProperty(value = "The time the event occured.")

  @Valid

  public OffsetDateTime getTimeOcurred() {
    return timeOcurred;
  }

  public void setTimeOcurred(OffsetDateTime timeOcurred) {
    this.timeOcurred = timeOcurred;
  }

  public SettlementAccountStateChangeEvent payload(SettlementAccountStateChangeEventPayload payload) {
    this.payload = payload;
    return this;
  }

  /**
   * The event payload linked to the involved resource object
   * @return payload
  **/
  @ApiModelProperty(value = "The event payload linked to the involved resource object")

  @Valid

  public SettlementAccountStateChangeEventPayload getPayload() {
    return payload;
  }

  public void setPayload(SettlementAccountStateChangeEventPayload payload) {
    this.payload = payload;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettlementAccountStateChangeEvent settlementAccountStateChangeEvent = (SettlementAccountStateChangeEvent) o;
    return Objects.equals(this.id, settlementAccountStateChangeEvent.id) &&
        Objects.equals(this.href, settlementAccountStateChangeEvent.href) &&
        Objects.equals(this.eventId, settlementAccountStateChangeEvent.eventId) &&
        Objects.equals(this.eventTime, settlementAccountStateChangeEvent.eventTime) &&
        Objects.equals(this.eventType, settlementAccountStateChangeEvent.eventType) &&
        Objects.equals(this.correlationId, settlementAccountStateChangeEvent.correlationId) &&
        Objects.equals(this.domain, settlementAccountStateChangeEvent.domain) &&
        Objects.equals(this.title, settlementAccountStateChangeEvent.title) &&
        Objects.equals(this.description, settlementAccountStateChangeEvent.description) &&
        Objects.equals(this.priority, settlementAccountStateChangeEvent.priority) &&
        Objects.equals(this.timeOcurred, settlementAccountStateChangeEvent.timeOcurred) &&
        Objects.equals(this.payload, settlementAccountStateChangeEvent.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, eventId, eventTime, eventType, correlationId, domain, title, description, priority, timeOcurred, payload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettlementAccountStateChangeEvent {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    timeOcurred: ").append(toIndentedString(timeOcurred)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

