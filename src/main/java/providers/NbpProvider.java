package providers;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import providers.data.NbpTableA;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NbpProvider {

    public static void main(String[] args) {
        getNbpTableA();
    }

    private static List<NbpTableA> getNbpTableA()
    {
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/A/";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        Gson gson = new Gson();
        ArrayList<NbpTableA> nbpTableA = new ArrayList<>(Arrays.asList(gson.fromJson(result,NbpTableA[].class)));
        System.out.println(nbpTableA.get(0).getRates().get(0).getCode() + " " + nbpTableA.get(0).getRates().get(0).getMid());
        return nbpTableA;
    }
}
