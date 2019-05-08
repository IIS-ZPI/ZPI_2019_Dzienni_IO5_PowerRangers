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
    List<RatesWithCurrency> twoWeek;
    List<DataForResponse> listOfCalculatedDiffrencesOneWeek = new ArrayList<>();
    List<DataForResponse> listOfCalculatedDiffrencesTwoWeek = new ArrayList<>();

    public List<NbpTableA> getNbpTableA()
    {
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/A/";

        String result = restTemplate.getForObject(uri, String.class);
        List<NbpTableA> nbpTableA = new ArrayList<>(Arrays.asList(gson.fromJson(result,NbpTableA[].class)));
        return nbpTableA;
    }


    private void getAllSessionInOneWeek(Currency userCurrency) {
        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);

        LocalDate startDate = LocalDate.now().minusDays(8);
        startDate.format(formatter);

        String urlOneWeek = "http://api.nbp.pl/api/exchangerates/rates/A/"+userCurrency.toString()+"/"+startDate+"/"+endDate;

        String result = restTemplate.getForObject(urlOneWeek, String.class);
        oneWeek = gson.fromJson(result, NBPTableWithCurrency.class).getRates();
    }

    private void getAllSessionTwoWeek(Currency userCurrency) {
        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);

        LocalDate startDate = LocalDate.now().minusDays(15);
        startDate.format(formatter);

        String urlTwoWeek = "http://api.nbp.pl/api/exchangerates/rates/A/"+userCurrency.toString()+"/"+startDate+"/"+endDate;

        String result = restTemplate.getForObject(urlTwoWeek, String.class);
        twoWeek = gson.fromJson(result, NBPTableWithCurrency.class).getRates();
    }


    private void getDiffrencesSessionInOneWeek(Currency userCurrency){
        getAllSessionInOneWeek(userCurrency);

        for (int i = 1; i < oneWeek.size() ; i++) {
            double midI = oneWeek.get(i).getMid();
            double midIBefore = oneWeek.get(i-1).getMid();
            listOfCalculatedDiffrencesOneWeek.add(new DataForResponse(midI - midIBefore,oneWeek.get(i).getEffectiveDate()));
        }
    }

    private void getDiffrencesSessionInTwoWeek(Currency userCurrency){
        getAllSessionTwoWeek(userCurrency);

        for (int i = 1; i < twoWeek.size() ; i++) {
            double midI = twoWeek.get(i).getMid();
            double midIBefore = twoWeek.get(i-1).getMid();
            listOfCalculatedDiffrencesTwoWeek.add(new DataForResponse(midI - midIBefore,twoWeek.get(i).getEffectiveDate()));
        }
    }

    public List<DataForResponse> getDownwardSessionsInWeek(Currency userCurrency){
        getDiffrencesSessionInOneWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesOneWeek.stream()
                                                                        .filter(dataForResponse -> dataForResponse.getDifference() < 0)
                                                                        .collect(Collectors.toList());
        listOfCalculatedDiffrencesOneWeek.clear();
        return result;


    }

    public List<DataForResponse> getGrowthSessionsInWeek(Currency userCurrency){
        getDiffrencesSessionInOneWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesOneWeek.stream()
                                                                        .filter(dataForResponse -> dataForResponse.getDifference() > 0)
                                                                        .collect(Collectors.toList());
        listOfCalculatedDiffrencesOneWeek.clear();
        return result;

    }

    public List<DataForResponse> getInvariableSessionsInWeek(Currency userCurrency){
        getDiffrencesSessionInOneWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesOneWeek.stream()
                                                                        .filter(dataForResponse -> dataForResponse.getDifference() == 0)
                                                                        .collect(Collectors.toList());
        listOfCalculatedDiffrencesOneWeek.clear();
        return result;
    }

    public List<DataForResponse> getDownwardSessionsInTwoWeeks(Currency userCurrency){
        getDiffrencesSessionInTwoWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesTwoWeek.stream()
                                                                        .filter(dataForResponse -> dataForResponse.getDifference() < 0)
                                                                        .collect(Collectors.toList());
        listOfCalculatedDiffrencesTwoWeek.clear();
        return result;


    }

    public List<DataForResponse> getGrowthSessionsInTwoWeeks(Currency userCurrency){
        getDiffrencesSessionInTwoWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesTwoWeek.stream()
                                                                        .filter(dataForResponse -> dataForResponse.getDifference() > 0)
                                                                        .collect(Collectors.toList());
        listOfCalculatedDiffrencesTwoWeek.clear();
        return result;

    }

    public List<DataForResponse> getInvariableSessionsInTwoWeeks(Currency userCurrency){
        getDiffrencesSessionInTwoWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesTwoWeek.stream()
                                                                        .filter(dataForResponse -> dataForResponse.getDifference() == 0)
                                                                        .collect(Collectors.toList());
        listOfCalculatedDiffrencesTwoWeek.clear();
        return result;
    }

}
