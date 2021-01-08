//package mapp.jwtsecurity;
//
//import mapp.jwtsecurity.filters.JwtRequestFilter;
//import mapp.jwtsecurity.models.AuthenticationRequest;
//import mapp.jwtsecurity.models.AuthenticationResponse;
//import mapp.jwtsecurity.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//    class HelloWorldController {
//
//    
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private JwtUtil jwtTokenUtil;
//
//	@Autowired
//	private MyUserDetailsService userDetailsService;
//
//	@RequestMapping({ "/hello" })
//	public String firstPage() {
//		return "Hello World";
//	}
//
//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
//			);
//		}
//		catch (BadCredentialsException e) {
//			throw new Exception("Incorrect username or password", e);
//		}
//
//
//		final UserDetails userDetails = userDetailsService
//				.loadUserByUsername(authenticationRequest.getUsername());
//
//		final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//		return ResponseEntity.ok(new AuthenticationResponse(jwt));
//	}
//
//}
//
//@EnableWebSecurity
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserDetailsService myUserDetailsService;
//	@Autowired
//	private JwtRequestFilter jwtRequestFilter;
//
//        @Autowired
//        private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//        
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(myUserDetailsService);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.cors().and().csrf().disable()
//                                        // Authentication pages do not require permissions
//				.authorizeRequests().antMatchers("/authenticate")
//                                .permitAll().
//			        //Other pages		
//                        anyRequest().authenticated().and().
//                        //Login Page Simulator Client
//                formLogin().loginPage("/login.html").permitAll().
////                         loginProcessingUrl("/authentication").permitAll(). 
//                        and().
//                                        // store user's state.
//						exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//                                        //Do not use session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//                
//	}
//
//}