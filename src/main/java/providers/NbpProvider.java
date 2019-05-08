package providers;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import providers.data.NBPTableWithCurrency;
import providers.data.NbpTableA;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

@Service
public class NbpProvider {

    Gson gson = new Gson();
    RestTemplate restTemplate = new RestTemplate();

    public List<NbpTableA> getNbpTableA()
    {
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/A/";

        String result = restTemplate.getForObject(uri, String.class);
        List<NbpTableA> nbpTableA = new ArrayList<>(Arrays.asList(gson.fromJson(result,NbpTableA[].class)));
        return nbpTableA;
    }

    public void getAllSessionsInOneWeek(Currency userCurrency){

        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);

        LocalDate startDate = LocalDate.now().minusDays(7);
        startDate.format(formatter);


        String urlOneWeek = "http://api.nbp.pl/api/exchangerates/rates/A/"+userCurrency.toString()+"/"+startDate+"/"+endDate;

        String result = restTemplate.getForObject(urlOneWeek, String.class);
        List<NBPTableWithCurrency> nbpTableA = new ArrayList<>(Arrays.asList(gson.fromJson(result,NBPTableWithCurrency.class)));

        nbpTableA.forEach(s-> System.out.println(s));


    }
}
