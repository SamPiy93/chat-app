package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ApiEnv class to represent API_ENV table
 *
 */
@Entity
@Table(name = "USERS")
public class UserModel extends Model {
    @Id
    @Column(name = "USER_ID",nullable = false)
    private int userId;

    @Column(name = "USER_FIRSTNAME",nullable = false)
    private String userFirstName;

    @Column(name = "USER_LASTNAME",nullable = false)
    private String userLastName;

    @Column(name = "USER_EMAIL",nullable = false)
    private String userEmail;

    @Column(name = "USER_PASSWORD",nullable = false)
    private String userPassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
