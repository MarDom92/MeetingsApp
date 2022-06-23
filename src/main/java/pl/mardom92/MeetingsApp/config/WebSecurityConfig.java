package pl.mardom92.MeetingsApp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public DaoAuthenticationProvider authProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                    .and()
                .authorizeRequests()
                //TODO: fix - roles when login by OAuth2
//                    .antMatchers("/**").hasAnyAuthority("ADMIN", "USER")
//                    .antMatchers("/users/**").hasAuthority("ADMIN")
                    .and()
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .defaultSuccessUrl("/events")
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login").permitAll()
                    .and()
                .oauth2Login()
                    .defaultSuccessUrl("/events").permitAll();

        http.cors().and().csrf().disable();
    }
}
