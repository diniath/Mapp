//package mapp.security;
//
//import static java.lang.Compiler.disable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserDetailsService userDetailsService;
//    
//    // Authentication 
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
////        auth.authenticationProvider(authenticationProvider());
//    }
//    
////        @Bean
////        public DaoAuthenticationProvider authenticationProvider(){
////        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
////        auth.setUserDetailsService(userDetailsService);
////        auth.setPasswordEncoder(getPasswordEncoder());
////        return auth;
////    }
//    
//    // Authorization 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and()
//                .csrf().disable().authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/").permitAll()
////        .antMatchers("/resources/**").permitAll()
////                .antMatchers("/")
////                .permitAll()
//        .anyRequest().authenticated()
//                
//        .and()
//             .formLogin()
//             .loginPage("/login.html")
//             .loginProcessingUrl("/login")
//             .permitAll();
//                
//                   
////                .csrf().disable().authorizeRequests()             
////                .antMatchers("/admin").hasRole("ADMIN")
////                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
////                .antMatchers("/").permitAll()
////                .anyRequest().authenticated() 
////          .and().formLogin().loginPage("/login.html");                 
//                
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
