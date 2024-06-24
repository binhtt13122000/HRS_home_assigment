package demo.booking.config;

import demo.booking.entities.User;
import demo.booking.security.SecurityUser;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        SecurityUser basicActiveUser = new SecurityUser("user", "password", List.of(new SimpleGrantedAuthority("ROLE_USER")), new User());

        return new InMemoryUserDetailsManager(List.of(basicActiveUser));
    }
}
