package ivi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

public class UserAuthorizationInApiModel {
    @JsonProperty("clientId")
    private String clientId = null;

    @JsonProperty("clientSecret")
    private String clientSecret = null;

    public UserAuthorizationInApiModel clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * Get clientId
     * @return clientId
     **/
    @Schema(required = true, description = "")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public UserAuthorizationInApiModel clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    /**
     * Get clientSecret
     * @return clientSecret
     **/
    @Schema(required = true, description = "")
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAuthorizationInApiModel userAuthorizationInApiModel = (UserAuthorizationInApiModel) o;
        return Objects.equals(this.clientId, userAuthorizationInApiModel.clientId) &&
                Objects.equals(this.clientSecret, userAuthorizationInApiModel.clientSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientSecret);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserAuthorizationInApiModel {\n");

        sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
        sb.append("    clientSecret: ").append(toIndentedString(clientSecret)).append("\n");
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
