package fr.mlsof.mlsoft.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"fr.mlsof.mlsoft.controller"})
public class WebMvcConfig implements WebMvcConfigurer {

}