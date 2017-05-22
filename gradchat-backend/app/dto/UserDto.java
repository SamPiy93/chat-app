package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by sameerap on 22/05/2017.
 */
@JsonPropertyOrder({"USER_ID", "USER_FIRSTNAME", "USER_LASTNAME", "USER_EMAIL", "USER_PASSWORD"})
public class UserDto {
    @JsonProperty("USER_ID")
    private Long userId;

    @JsonProperty("USER_FIRSTNAME")
    private String userFirstName;

    @JsonProperty("USER_LASTNAME")
    private String userLastName;

    @JsonProperty("USER_EMAIL")
    private String userEmail;

    @JsonProperty("USER_PASSWORD")
    private String userPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
