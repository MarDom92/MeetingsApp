package pl.mardom92.MeetingsApp.model.builder.builder;

import pl.mardom92.MeetingsApp.model.entity.UserEntity;
import pl.mardom92.MeetingsApp.model.enums.UserRole;

public class UserEntityBuilder {

    private long id;

    private String email;
    private String password;

    private String username;

    private String firstname;
    private String lastname;

    private UserRole userRole;

    public UserEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public UserEntityBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntityBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntityBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserEntityBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserEntityBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserEntityBuilder withUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public UserEntity build() {

        UserEntity userEntity = new UserEntity();

        userEntity.setId(id);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setUsername(username);
        userEntity.setFirstname(firstname);
        userEntity.setLastname(lastname);
        userEntity.setUserRole(userRole);

        return userEntity;
    }
}
