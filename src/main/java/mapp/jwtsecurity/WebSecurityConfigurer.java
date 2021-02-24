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
    private MyCompanyDetailsService myCompanyDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).and().
                userDetailsService(myCompanyDetailsService);

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
            = {"/auth/user", "/auth/company", "/cart", "/category/**",
                "/company/**", "/ordering/**", "/orderlist/**", "/product/**",
                "/review/**", "/schedule/**", "/subcategory/**",
                              "/enrolledUser/**", 
                "/mapp/**", "/chat/css/main.css", "/chat/js/main.js",
                "/front/**", 
                "/front/assets/css/modals.css",
                "/assets/css/myBootstrap.css",
                "/front/assets/js/animation.js",
                "/front/assets/img/header-logo.png",
                "/front/assets/img/team-presentation.jpg",
                "/front/results.html", "/product/search/**", "/charge",
                "/create-subscription", "/create-charge", "/cancel-subscription",
                "/subscription", "/user_cp.html"
            };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeRequests().
                antMatchers(CLASSPATH_RESOURCE_LOCATIONS).permitAll().
                // Authentication pages do not require permissions
                antMatchers("/delete/**").hasRole("ADMIN").
                antMatchers("/put/**").hasRole("ADMIN").
                antMatchers("/role/**").hasRole("ADMIN").               
                antMatchers("/").permitAll().
                //Other pages		
                anyRequest().authenticated().
                and().
                exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
                and(). //Do not use session
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
