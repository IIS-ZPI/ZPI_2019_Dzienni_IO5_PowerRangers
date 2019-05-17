package caishenproject.caishen;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CaishenApplication {

    public static void main(String[] args) {

        SpringApplication.run(CaishenApplication.class, args);
    }

}
