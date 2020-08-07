package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Introspected;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * MailingListSubscriptionRequest
 */
@JsonPropertyOrder({
  MailingListSubscriptionRequest.JSON_PROPERTY_EMAIL
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2020-08-01T10:57:25.305764-04:00[America/New_York]")
@Introspected
public class MailingListSubscriptionRequest   {
  public static final String JSON_PROPERTY_EMAIL = "email";
  @JsonProperty(JSON_PROPERTY_EMAIL)
  private String email;

  public MailingListSubscriptionRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @JsonProperty("email")
  @ApiModelProperty(value = "")
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailingListSubscriptionRequest mailingListSubscriptionRequest = (MailingListSubscriptionRequest) o;
    return Objects.equals(this.email, mailingListSubscriptionRequest.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailingListSubscriptionRequest {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

