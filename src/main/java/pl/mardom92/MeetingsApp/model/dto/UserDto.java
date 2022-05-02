package pl.mardom92.MeetingsApp.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.MeetingsApp.model.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class UserDto {

    private String email;

    private String username;

    private String firstname;
    private String lastname;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
