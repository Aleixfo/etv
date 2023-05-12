package aleix.etv.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "aleix.etv")
@SpringBootApplication
@EntityScan("aleix.etv.entity")
public class EtvApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtvApplication.class, args);



	}



}
