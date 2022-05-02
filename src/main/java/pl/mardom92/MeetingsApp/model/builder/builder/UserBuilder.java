package pl.mardom92.MeetingsApp.model.builder.builder;

import pl.mardom92.MeetingsApp.model.entity.User;
import pl.mardom92.MeetingsApp.model.enums.UserRole;

public class UserBuilder {

    private long id;

    private String email;
    private String password;

    private String username;

    private String firstname;
    private String lastname;

    private UserRole userRole;

    public UserBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserBuilder withUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public User build() {

        User user = new User();

        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUserRole(userRole);

        return user;
    }
}
