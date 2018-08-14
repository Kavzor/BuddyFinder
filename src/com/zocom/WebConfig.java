package com.zocom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.zocom")
@EnableWebMvc
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/WEB-INF/"); //g�r s� att kontrollern letar under /WEB-INF/ efter jsp filer
	}
	
	//Skapa en fil under WebContent med namnet resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
	}
	

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        //.csrf().disable()
        .authorizeRequests()
            .antMatchers("/", "/home", "/resources/**").permitAll() //godk�nda addreser utan inlogg
            .anyRequest().authenticated() //�vriga m�ste du logga in f�r att n�
            .and()
        .formLogin() //aktiverar spring security login form
        	.loginPage("/login") //omdirigerar till ditt egna formul�r
        	.defaultSuccessUrl("/profile")
        	.failureUrl("/login?error=credentials")
        	.permitAll()
            .and()
        .logout() //triggas av att urlen slutar p� /logout
            .permitAll();
    }
  
	//Skapar en anv�ndare i minnet
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authManager) throws Exception {
		authManager
			.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder())
			.withUser("test")
			.password(passwordEncoder().encode("test"))
			.roles("USER");
	}
	
	//Spring security KR�VER att alla l�ssenord krypteras
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//En helt udda b�na som du inte beh�ver f�rr�n du tittar p� rest services
	@Bean
	public String getMessage() {
		return "hello worldssssssssss";
	}
}
