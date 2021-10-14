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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.UUID;

/**
 * Device
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-10-14T15:04:07.856806300+02:00[Europe/Paris]")
public class Device {
  public static final String SERIALIZED_NAME_DEVICE_IDENTIFIER = "deviceIdentifier";
  @SerializedName(SERIALIZED_NAME_DEVICE_IDENTIFIER)
  private String deviceIdentifier;

  public static final String SERIALIZED_NAME_FCMTOKEN = "fcmtoken";
  @SerializedName(SERIALIZED_NAME_FCMTOKEN)
  private String fcmtoken;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
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

  public String getDeviceIdentifier() {
    return deviceIdentifier;
  }


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

  public String getFcmtoken() {
    return fcmtoken;
  }


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

  public UUID getId() {
    return id;
  }


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

