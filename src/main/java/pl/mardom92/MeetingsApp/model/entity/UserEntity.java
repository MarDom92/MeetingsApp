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

@Getter
@Setter
@Entity
public class UserEntity implements UserDetails {

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

    @Column(name = "is_expired")
    boolean isExpired;
    @Column(name = "is_locked")
    boolean isLocked;
    @Column(name = "is_credentials_expired")
    boolean isCredentialsExpired;
    @Column(name = "is_enabled")
    boolean isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority((userRole.name()));

        return Collections.singletonList(authority);
    }

    @Override
    public boolean isAccountNonExpired() {

        return !isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {

        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
