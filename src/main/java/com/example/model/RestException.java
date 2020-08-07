package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * RestException
 */
@JsonPropertyOrder({
  RestException.JSON_PROPERTY_CODE,
  RestException.JSON_PROPERTY_TITLE,
  RestException.JSON_PROPERTY_DESCRIPTION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2020-08-01T10:57:25.305764-04:00[America/New_York]")
public class RestException   {
  public static final String JSON_PROPERTY_CODE = "code";
  @JsonProperty(JSON_PROPERTY_CODE)
  private Integer code;

  public static final String JSON_PROPERTY_TITLE = "title";
  @JsonProperty(JSON_PROPERTY_TITLE)
  private String title;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  private String description;

  public RestException code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @JsonProperty("code")
  @ApiModelProperty(value = "")
  
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public RestException title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @JsonProperty("title")
  @ApiModelProperty(value = "")
  
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public RestException description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @JsonProperty("description")
  @ApiModelProperty(value = "")
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestException restException = (RestException) o;
    return Objects.equals(this.code, restException.code) &&
        Objects.equals(this.title, restException.title) &&
        Objects.equals(this.description, restException.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, title, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestException {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

