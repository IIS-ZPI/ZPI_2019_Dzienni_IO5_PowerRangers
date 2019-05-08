package caishenproject.caishen.providers;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import caishenproject.caishen.providers.data.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NbpProvider {

    Gson gson = new Gson();
    RestTemplate restTemplate = new RestTemplate();
    List<RatesWithCurrency> oneWeek;

    List<DataForResponse> listOfCalculatedDiffrences = new ArrayList<>();

    public List<NbpTableA> getNbpTableA()
    {
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/A/";

        String result = restTemplate.getForObject(uri, String.class);
        List<NbpTableA> nbpTableA = new ArrayList<>(Arrays.asList(gson.fromJson(result,NbpTableA[].class)));
        return nbpTableA;
    }

    private void getAllSessionsInOneWeek(Currency userCurrency){

        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);

        LocalDate startDate = LocalDate.now().minusDays(8);
        startDate.format(formatter);

        String urlOneWeek = "http://api.nbp.pl/api/exchangerates/rates/A/"+userCurrency.toString()+"/"+startDate+"/"+endDate;

        String result = restTemplate.getForObject(urlOneWeek, String.class);
        oneWeek = gson.fromJson(result,NBPTableWithCurrency.class).getRates();

    }

    private void getDiffrencesSessionInOneWeek(Currency userCurrency){
        getAllSessionsInOneWeek(userCurrency);

        for (int i = 1; i < oneWeek.size() ; i++) {
            double midI = oneWeek.get(i).getMid();
            double midIBefore = oneWeek.get(i-1).getMid();
            listOfCalculatedDiffrences.add(new DataForResponse(midI-midIBefore,oneWeek.get(i).getEffectiveDate()));
        }
    }

    public List<DataForResponse> getDownwardSessionsInWeek(Currency userCurrency){
        getDiffrencesSessionInOneWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrences.stream()
                                                                  .filter(dataForResponse -> dataForResponse.getDifference() < 0)
                                                                  .collect(Collectors.toList());
        listOfCalculatedDiffrences.clear();
        return result;


    }

    public List<DataForResponse> getGrowthSessionsInWeek(Currency userCurrency){
        getDiffrencesSessionInOneWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrences.stream()
                                                                  .filter(dataForResponse -> dataForResponse.getDifference() > 0)
                                                                  .collect(Collectors.toList());
        listOfCalculatedDiffrences.clear();
        return result;

    }

    public List<DataForResponse> getInvariableSessionsInWeek(Currency userCurrency){
        getDiffrencesSessionInOneWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrences.stream()
                                                                  .filter(dataForResponse -> dataForResponse.getDifference() == 0)
                                                                  .collect(Collectors.toList());
        listOfCalculatedDiffrences.clear();
        return result;
    }

}
