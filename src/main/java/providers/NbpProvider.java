package providers;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import providers.data.NbpTableA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NbpProvider {


    public List<NbpTableA> getNbpTableA()
    {
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/A/";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        Gson gson = new Gson();
        ArrayList<NbpTableA> nbpTableA = new ArrayList<>(Arrays.asList(gson.fromJson(result,NbpTableA[].class)));
        return nbpTableA;
    }
}
