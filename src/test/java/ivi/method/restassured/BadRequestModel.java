package ivi.method.restassured;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BadRequestModel {
    @JsonProperty("type")
    private String type = null;

    @JsonProperty("title")
    private String title = null;

    @JsonProperty("status")
    private Integer status = null;

    @JsonProperty("errors")
    private Map<String, List<String>> errors = null;

    @JsonProperty("source")
    private String source = null;

    /**
     * Get type
     * @return type
     **/

    public String getType() {
        return type;
    }

    /**
     * Get title
     * @return title
     **/

    public String getTitle() {
        return title;
    }

    public BadRequestModel status(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     * @return status
     **/

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BadRequestModel errors(Map<String, List<String>> errors) {
        this.errors = errors;
        return this;
    }

    public BadRequestModel putErrorsItem(String key, List<String> errorsItem) {
        if (this.errors == null) {
            this.errors = new HashMap<>();
        }
        this.errors.put(key, errorsItem);
        return this;
    }

    /**
     * Get errors
     * @return errors
     **/

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
    }

    public BadRequestModel source(String source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     * @return source
     **/
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BadRequestModel badRequestModel = (BadRequestModel) o;
        return Objects.equals(this.type, badRequestModel.type) &&
                Objects.equals(this.title, badRequestModel.title) &&
                Objects.equals(this.status, badRequestModel.status) &&
                Objects.equals(this.errors, badRequestModel.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, status, errors);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BadRequestModel {\n");

        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
