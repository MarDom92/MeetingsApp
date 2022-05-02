package pl.mardom92.MeetingsApp.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.mardom92.MeetingsApp.model.enums.UserRole;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity(name = "user_account")
@Getter
@Setter
public class User implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority((userRole.name()));

        return Collections.singletonList(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        //TODO: add variable
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //TODO: add variable
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //TODO: add variable
        return true;
    }

    @Override
    public boolean isEnabled() {
        //TODO: add variable
        return true;
    }
}
