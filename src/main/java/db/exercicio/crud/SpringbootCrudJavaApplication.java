package db.exercicio.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EntityScan(basePackages = "db.exercicio.crud.model")
@ComponentScan(basePackages = "db.*")
@EnableJpaRepositories(basePackages = {"db.exercicio.crud.repository"})
@EnableTransactionManagement()
public class SpringbootCrudJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudJavaApplication.class, args);
	}
}
