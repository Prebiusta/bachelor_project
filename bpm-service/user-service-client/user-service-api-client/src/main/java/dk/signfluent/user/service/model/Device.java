/*
 * TITLE
 * DESCRIPTION
 *
 * The version of the OpenAPI document: VERSION
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package dk.signfluent.user.service.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Device
 */
@JsonPropertyOrder({
  Device.JSON_PROPERTY_DEVICE_IDENTIFIER,
  Device.JSON_PROPERTY_FCMTOKEN,
  Device.JSON_PROPERTY_ID
})
@JsonTypeName("Device")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-10-14T14:41:50.888430+02:00[Europe/Copenhagen]")
public class Device {
  public static final String JSON_PROPERTY_DEVICE_IDENTIFIER = "deviceIdentifier";
  private String deviceIdentifier;

  public static final String JSON_PROPERTY_FCMTOKEN = "fcmtoken";
  private String fcmtoken;

  public static final String JSON_PROPERTY_ID = "id";
  private UUID id;


  public Device deviceIdentifier(String deviceIdentifier) {
    
    this.deviceIdentifier = deviceIdentifier;
    return this;
  }

   /**
   * Get deviceIdentifier
   * @return deviceIdentifier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DEVICE_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDeviceIdentifier() {
    return deviceIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_DEVICE_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeviceIdentifier(String deviceIdentifier) {
    this.deviceIdentifier = deviceIdentifier;
  }


  public Device fcmtoken(String fcmtoken) {
    
    this.fcmtoken = fcmtoken;
    return this;
  }

   /**
   * Get fcmtoken
   * @return fcmtoken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FCMTOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFcmtoken() {
    return fcmtoken;
  }


  @JsonProperty(JSON_PROPERTY_FCMTOKEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFcmtoken(String fcmtoken) {
    this.fcmtoken = fcmtoken;
  }


  public Device id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UUID getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(UUID id) {
    this.id = id;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Device device = (Device) o;
    return Objects.equals(this.deviceIdentifier, device.deviceIdentifier) &&
        Objects.equals(this.fcmtoken, device.fcmtoken) &&
        Objects.equals(this.id, device.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceIdentifier, fcmtoken, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Device {\n");
    sb.append("    deviceIdentifier: ").append(toIndentedString(deviceIdentifier)).append("\n");
    sb.append("    fcmtoken: ").append(toIndentedString(fcmtoken)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

