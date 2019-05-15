package fr.mlsof.mlsoft.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"fr.mlsof.mlsoft.repository"})
public class ContextConfig {

}
