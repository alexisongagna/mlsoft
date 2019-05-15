package fr.mlsof.mlsoft;

import fr.mlsof.mlsoft.model.Personne;
import fr.mlsof.mlsoft.repository.PersonneJDBCTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableSwagger2
public class MlsoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlsoftApplication.class, args);
			}
}

