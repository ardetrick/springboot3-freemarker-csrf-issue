package com.ardetrick.freemarkercsrf;

//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class FreemarkerCsrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreemarkerCsrfApplication.class, args);
	}

}

@Configuration
@EnableWebSecurity
@EnableWebMvc
class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		var handler = new XorCsrfTokenRequestAttributeHandler();
		handler.setCsrfRequestAttributeName(CsrfToken.class.getName());
		http
				.csrf((csrf) -> csrf
						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
						.csrfTokenRequestHandler(handler)
				);

		return http.build();
	}

}

@Controller
@RequestMapping("demo")
class SampleController {

	@GetMapping
	public ModelAndView getDemo() {
		return new ModelAndView("demo")
				.addObject("workingAttribute", "this works");
	}

}