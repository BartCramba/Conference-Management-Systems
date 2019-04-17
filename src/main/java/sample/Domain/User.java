package sample.Domain;

/**
 * Working register form
 */
public class User {

    private int userId;

    private String firstName;
    private String lastName;
    private String email;
    private String passsword;

    private UserRole role;

    public User(String firstName, String lastName, String email, String passsword, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passsword = passsword;
        this.role = role;
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
