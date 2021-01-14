package mapp.jwtsecurity;

import mapp.jwtsecurity.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService myUserDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS
            = {
                "/login.html", "/"
//                    , "/front/**"
//                    , "/css/**"
//                    , "/home", "/charge", "/subscription",
//                "/style.css",
//                "/front/-about.html", "/front/assets/css/modals.css",
//                "/front/assets/css/myBootstrap.css",
//                "/front/assets/js/animation.js",
//                "/front/assets/img/header-logo.png",
//                "/front/assets/img/team-presentation.jpg",
//                "/front/results.html", "/product/search/**"
            };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeRequests().
                antMatchers(CLASSPATH_RESOURCE_LOCATIONS).permitAll().
                // Authentication pages do not require permissions
                antMatchers("/authenticate").permitAll().
                antMatchers("/role/**").hasRole("USER").
                antMatchers("/").permitAll().
                antMatchers("/favicon.ico").permitAll().
                //Other pages		
                anyRequest().authenticated().
                and().
                exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
                and(). //Do not use session
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
