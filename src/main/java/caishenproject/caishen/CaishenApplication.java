package caishenproject.caishen;

import Endpoints.NbpTableController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import providers.data.NbpTableA;

@SpringBootApplication
@Import(NbpTableController.class)
public class CaishenApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaishenApplication.class, args);
    }

}
