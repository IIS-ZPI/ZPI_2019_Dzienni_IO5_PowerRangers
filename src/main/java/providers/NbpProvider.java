package providers;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import providers.data.NbpTableA;

import java.util.List;

public class NbpProvider {

    public static void main(String[] args) {
        getNbpTableA();
    }

    private static void getNbpTableA()
    {
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/A/";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        Gson gson = new Gson();
        NbpTableA nbpTableA[] = gson.fromJson(result,NbpTableA[].class);
        System.out.println(nbpTableA[0].getNo());
    }
}
