package sample.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

/**
 * Working register form
 */

@Entity
@Table(name="Users")
@NamedQuery(
        name="User.findByUsername",
        query="SELECT u FROM User u WHERE u.email = :email and u.passsword = :password"
)
@NamedQuery(
        name="User.findByEmail",
        query="SELECT u FROM User u WHERE u.email = :email"
)
@NamedQuery(
        name="User.updateRole",
        query="update User SET role = :role where email = :email"
)
//@SQLInsert( sql="INSERT INTO Users(userId, firstName, lastName, email, password, userRole) VALUES(?,?,?,?,?,?)")
//@SQLUpdate( sql="UPDATE Users SET firstName = ?, lastName = ?, email = ?, password = ?, userRole = ? WHERE userId = ?")
//@SQLDelete( sql="DELETE Users WHERE userId = ?")
public class User {

    public static final String USER_LOGIN = "User.findByUsername";
    public static final String USER_EMAIL = "User.findByEmail";
    public static final String USER_setrole = "User.updateRole";
    public static final String ROLE = "role";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    @Id
    @GeneratedValue
    private int userId;

    private String firstName;
    private String lastName;
    private String email;
    @Column(name="password")
    private String passsword;

    @Enumerated(EnumType.STRING)
    @Column(name="userRole")
    private UserRole role;

    public User(String firstName, String lastName, String email, String passsword, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passsword = passsword;
        this.role = role;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passsword='" + passsword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static enum UserRole {
        chair("ROLE_CHAIR"),
        coChair("ROLE_CO_CHAIR"),
        listener("ROLE_LISTENER"),
        author("ROLE_AUTHOR"),
        speaker("ROLE_SPEAKER"),
        user("ROLE_USER"),
        superAdmin("ROLE_SUPER_ADMIN");

        /**
         * Name of the role
         */
        private String nume;

        /**
         * Create a new role with a name
         * @param nume
         */
        UserRole(String nume) {
            this.nume = nume;
        }

        @Override
        public String toString() {
            return this.nume;
        }
    }
}
