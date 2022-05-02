package pl.mardom92.MeetingsApp.model.entity;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.MeetingsApp.model.enums.UserRole;

import javax.persistence.*;

@Entity(name = "user_account")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;

    private String username;

    private String firstname;
    private String lastname;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
