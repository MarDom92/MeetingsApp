package pl.mardom92.MeetingsApp.model.builder.dtoBuilder;

import pl.mardom92.MeetingsApp.model.dto.UserDto;
import pl.mardom92.MeetingsApp.model.enums.UserRole;

public class UserDtoBuilder {

    private String email;

    private String username;

    private String firstname;
    private String lastname;

    private UserRole userRole;

    public UserDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDtoBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDtoBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserDtoBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserDtoBuilder withUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public UserDto build() {

        UserDto userDto = new UserDto();

        userDto.setEmail(email);
        userDto.setUsername(username);
        userDto.setFirstname(firstname);
        userDto.setLastname(lastname);
        userDto.setUserRole(userRole);

        return userDto;
    }
}
