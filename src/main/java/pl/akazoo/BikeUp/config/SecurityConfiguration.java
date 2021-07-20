package pl.akazoo.BikeUp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.akazoo.BikeUp.service.CustomUserDetailsService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfiguration(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/app/*","/app","/app/").hasRole("USER")
                .antMatchers("/static","/static/**","/images","/images/**").permitAll()
                //TODO Nie robimy tego: zabezpieczamy ogólnie, odbezpieczamy szczegółowo
                .antMatchers("/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .defaultSuccessUrl("/app")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .csrf()
                .disable();
    }
}