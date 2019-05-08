package caishenproject.caishen;

import Endpoints.NbpTableController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import providers.NbpProvider;
import providers.data.NbpTableA;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
@EnableWebMvc
public class CaishenApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaishenApplication.class, args);
    }

}
