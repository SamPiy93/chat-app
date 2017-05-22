package models;

import com.avaje.ebean.Model;
import org.h2.schema.Sequence;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ApiEnv class to represent API_ENV table
 *
 */
@Entity
@Table(name = "USERS")
public class UserModel extends Model implements Serializable{
    @Id
    @Column(name = "USER_ID",nullable = false)
    private Long userId;

    @Column(name = "USER_FIRSTNAME",nullable = false)
    private String userFirstName;

    @Column(name = "USER_LASTNAME",nullable = false)
    private String userLastName;

    @Column(name = "USER_EMAIL",nullable = false)
    private String userEmail;

    @Column(name = "USER_PASSWORD",nullable = false)
    private String userPassword;

    public static Finder<Long, UserModel> find = new Finder<Long,UserModel>(UserModel.class);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (userId != null ? !userId.equals(userModel.userId) : userModel.userId != null) return false;
        if (userFirstName != null ? !userFirstName.equals(userModel.userFirstName) : userModel.userFirstName != null)
            return false;
        if (userLastName != null ? !userLastName.equals(userModel.userLastName) : userModel.userLastName != null)
            return false;
        if (userEmail != null ? !userEmail.equals(userModel.userEmail) : userModel.userEmail != null) return false;
        return userPassword != null ? userPassword.equals(userModel.userPassword) : userModel.userPassword == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
