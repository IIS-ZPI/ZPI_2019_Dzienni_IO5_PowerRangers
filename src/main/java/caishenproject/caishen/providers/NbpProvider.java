package caishenproject.caishen.providers;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import caishenproject.caishen.providers.data.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NbpProvider {

    Gson gson = new Gson();
    RestTemplate restTemplate = new RestTemplate();
    List<RatesWithCurrency> oneWeek;
    List<RatesWithCurrency> twoWeek;
    List<RatesWithCurrency> oneMonth;
    List<RatesWithCurrency> lastQuarter;
    List<RatesWithCurrency> halfYear;
    List<DataForResponse> listOfCalculatedDiffrencesOneWeek = new ArrayList<>();
    List<DataForResponse> listOfCalculatedDiffrencesTwoWeek = new ArrayList<>();
    List<DataForResponse> listOfCalculatedDiffrencesOneMonth = new ArrayList<>();
    List<DataForResponse> listOfCalculatedDiffrencesLastQuarter = new ArrayList<>();
    List<DataForResponse> getListOfCalculatedDiffrencesHalfYear = new ArrayList<>();

    public List<NbpTableA> getNbpTableA() {
        final String uri = "http://api.nbp.pl/api/exchangerates/tables/A/";

        String result = restTemplate.getForObject(uri, String.class);
        List<NbpTableA> nbpTableA = new ArrayList<>(Arrays.asList(gson.fromJson(result, NbpTableA[].class)));
        return nbpTableA;
    }


    private void getAllSessionInOneWeek(Currency userCurrency) {
        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);

        LocalDate startDate = LocalDate.now().minusDays(8);
        startDate.format(formatter);

        String urlOneWeek = "http://api.nbp.pl/api/exchangerates/rates/A/" + userCurrency.toString() + "/" + startDate + "/" + endDate;

        String result = restTemplate.getForObject(urlOneWeek, String.class);
        oneWeek = gson.fromJson(result, NBPTableWithCurrency.class).getRates();
    }

    private void getAllSessionTwoWeek(Currency userCurrency) {
        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);

        LocalDate startDate = LocalDate.now().minusDays(15);
        startDate.format(formatter);

        String urlTwoWeek = "http://api.nbp.pl/api/exchangerates/rates/A/" + userCurrency.toString() + "/" + startDate + "/" + endDate;

        String result = restTemplate.getForObject(urlTwoWeek, String.class);
        twoWeek = gson.fromJson(result, NBPTableWithCurrency.class).getRates();
    }

    private void getAllSessionOneMonth(Currency userCurrency) {
        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);

        LocalDate startDate = LocalDate.now().minusMonths(1);
        startDate.format(formatter);

        String urlOneMonth = "http://api.nbp.pl/api/exchangerates/rates/A/" + userCurrency.toString() + "/" + startDate + "/" + endDate;

        String result = restTemplate.getForObject(urlOneMonth, String.class);
        oneMonth = gson.fromJson(result, NBPTableWithCurrency.class).getRates();
    }
    private void getAllSessionHalfYear(Currency userCurrency) {
        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);

        LocalDate startDate = LocalDate.now().minusMonths(1);
        startDate.format(formatter);

        String urlHalfYear = "http://api.nbp.pl/api/exchangerates/rates/A/" + userCurrency.toString() + "/" + startDate + "/" + endDate;

        String result = restTemplate.getForObject(urlHalfYear, String.class);
        halfYear = gson.fromJson(result, NBPTableWithCurrency.class).getRates();
    }


    private void getDifferencesSessionInOneWeek(Currency userCurrency) {
        getAllSessionInOneWeek(userCurrency);

        for (int i = 1; i < oneWeek.size(); i++) {
            double midI = oneWeek.get(i).getMid();
            listOfCalculatedDiffrencesOneWeek.add(new DataForResponse(midI , oneWeek.get(i).getEffectiveDate()));
        }
    }

    private void getDifferencesSessionInTwoWeek(Currency userCurrency) {
        getAllSessionTwoWeek(userCurrency);

        for (int i = 1; i < twoWeek.size(); i++) {
            double midI = twoWeek.get(i).getMid();
            double midIBefore = twoWeek.get(i - 1).getMid();
            listOfCalculatedDiffrencesTwoWeek.add(new DataForResponse(midI - midIBefore, twoWeek.get(i).getEffectiveDate()));
        }
    }

    private void getDifferencesSessionInOneMonth(Currency userCurrency) {
        getAllSessionOneMonth(userCurrency);

        for (int i = 1; i < oneMonth.size(); i++) {
            double midI = oneMonth.get(i).getMid();
            double midIBefore = oneMonth.get(i - 1).getMid();
            listOfCalculatedDiffrencesOneMonth.add(new DataForResponse(midI - midIBefore, oneMonth.get(i).getEffectiveDate()));
        }
    }
    private void getDifferencesSessionInHalfYear(Currency userCurrency) {
        getAllSessionHalfYear(userCurrency);

        for (int i = 1; i < halfYear.size(); i++) {
            double midI = halfYear.get(i).getMid();
            double midIBefore = halfYear.get(i - 1).getMid();
            getListOfCalculatedDiffrencesHalfYear.add(new DataForResponse(midI - midIBefore, halfYear.get(i).getEffectiveDate()));
        }
    }

    public List<DataForResponse> getDownwardSessionsInWeek(Currency userCurrency) {
        getDifferencesSessionInOneWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesOneWeek.stream()
                .filter(dataForResponse -> dataForResponse.getMid() < 0)
                .collect(Collectors.toList());
        listOfCalculatedDiffrencesOneWeek.clear();
        return result;


    }

    public List<DataForResponse> getGrowthSessionsInWeek(Currency userCurrency) {
        getDifferencesSessionInOneWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesOneWeek.stream()
                .filter(dataForResponse -> dataForResponse.getMid() > 0)
                .collect(Collectors.toList());
        listOfCalculatedDiffrencesOneWeek.clear();
        return result;
    }

    public List<DataForResponse> getDownwardSessionsHalfYear(Currency userCurrency) {
        getDifferencesSessionInHalfYear(userCurrency);

        List<DataForResponse> result = getListOfCalculatedDiffrencesHalfYear.stream()
                .filter(dataForResponse -> dataForResponse.getMid() < 0)
                .collect(Collectors.toList());
        getListOfCalculatedDiffrencesHalfYear.clear();
        return result;

    }

    public List<DataForResponse> getGrowthSessionsHalfYear(Currency userCurrency) {
        getDifferencesSessionInHalfYear(userCurrency);

        List<DataForResponse> result = getListOfCalculatedDiffrencesHalfYear.stream()
                .filter(dataForResponse -> dataForResponse.getMid() > 0)
                .collect(Collectors.toList());
        getListOfCalculatedDiffrencesHalfYear.clear();
        return result;
    }
    public List<DataForResponse> getInvariableSessionsInHalfYear(Currency userCurrency) {

        getAllSessionHalfYear(userCurrency);

        List<DataForResponse> dataForResponses = new ArrayList<>();

        getDaysBetween(dataForResponses, halfYear);

        return dataForResponses;
    }


    public List<DataForResponse> getInvariableSessionsInWeek(Currency userCurrency) {

        getAllSessionInOneWeek(userCurrency);

        List<DataForResponse> dataForResponses = new ArrayList<>();

        getDaysBetween(dataForResponses, oneWeek);

        return dataForResponses;
    }

    public List<DataForResponse> getDownwardSessionsInTwoWeeks(Currency userCurrency) {
        getDifferencesSessionInTwoWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesTwoWeek.stream()
                .filter(dataForResponse -> dataForResponse.getMid() < 0)
                .collect(Collectors.toList());
        listOfCalculatedDiffrencesTwoWeek.clear();
        return result;
    }

    private void getDifferencesSessionInLastQuarter(Currency userCurrency) {
        getAllSessionLastQuarter(userCurrency);

        for (int i = 1; i < lastQuarter.size(); i++) {
            double midI = lastQuarter.get(i).getMid();
            double midIBefore = lastQuarter.get(i - 1).getMid();
            listOfCalculatedDiffrencesLastQuarter.add(new DataForResponse(midI - midIBefore, lastQuarter.get(i).getEffectiveDate()));
        }
    }

    public List<DataForResponse> getGrowthSessionsInTwoWeeks(Currency userCurrency) {
        getDifferencesSessionInTwoWeek(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesTwoWeek.stream()
                .filter(dataForResponse -> dataForResponse.getMid() > 0)
                .collect(Collectors.toList());
        listOfCalculatedDiffrencesTwoWeek.clear();
        return result;

    }

    public List<DataForResponse> getInvariableSessionsInTwoWeeks(Currency userCurrency) {

        getAllSessionTwoWeek(userCurrency);

        List<DataForResponse> dataForResponses = new ArrayList<>();

        getDaysBetween(dataForResponses, twoWeek);

        return dataForResponses;
    }

    private void getDaysBetween(List<DataForResponse> dataForResponses, List<RatesWithCurrency> twoWeek) {
        for (int i = 0; i < twoWeek.size() - 1; i++) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
            LocalDate from = LocalDate.parse(twoWeek.get(i).getEffectiveDate());
            from.format(formatter);

            LocalDate to = LocalDate.parse(twoWeek.get(i + 1).getEffectiveDate());
            to.format(formatter);

            for (LocalDate date = from.plusDays(1); date.isBefore(to); date = date.plusDays(1)) {
                dataForResponses.add(new DataForResponse(twoWeek.get(i).getMid(), date.toString()));
            }
        }
    }

    public List<DataForResponse> getDownwardSessionsInOneMonth(Currency userCurrency) {
        getDifferencesSessionInOneMonth(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesOneMonth.stream()
                .filter(dataForResponse -> dataForResponse.getMid() < 0)
                .collect(Collectors.toList());
        listOfCalculatedDiffrencesOneMonth.clear();
        return result;


    }

    public List<DataForResponse> getGrowthSessionsInOneMonth(Currency userCurrency) {
        getDifferencesSessionInOneMonth(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesOneMonth.stream()
                .filter(dataForResponse -> dataForResponse.getMid() > 0)
                .collect(Collectors.toList());
        listOfCalculatedDiffrencesOneMonth.clear();
        return result;

    }

    public List<DataForResponse> getInvariableSessionsInOneMonth(Currency userCurrency) {

        getAllSessionOneMonth(userCurrency);

        List<DataForResponse> dataForResponses = new ArrayList<>();

        getDaysBetween(dataForResponses, oneMonth);

        return dataForResponses;
    }

    private void getAllSessionLastQuarter(Currency userCurrency) {

        int whatQuarter = LocalDate.now().getMonthValue() % 4;
        LocalDate endDate = LocalDate.now().minusMonths(whatQuarter).withDayOfMonth(LocalDate.now().lengthOfMonth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        endDate.format(formatter);
        LocalDate startDate = endDate.minusMonths(4).withDayOfMonth(1);

        startDate.format(formatter);

        String urlLastQuarter = "http://api.nbp.pl/api/exchangerates/rates/A/" + userCurrency.toString() + "/" + startDate + "/" + endDate;

        String result = restTemplate.getForObject(urlLastQuarter, String.class);
        lastQuarter = gson.fromJson(result, NBPTableWithCurrency.class).getRates();
    }

    public List<DataForResponse> getInvariableSessionsInLastQuarter(Currency userCurrency) {

        getAllSessionLastQuarter(userCurrency);

        List<DataForResponse> dataForResponses = new ArrayList<>();

        getDaysBetween(dataForResponses, lastQuarter);

        return dataForResponses;
    }

    public List<DataForResponse> getGrowthSessionsInLastQuarter(Currency userCurrency) {
        getDifferencesSessionInLastQuarter(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesLastQuarter.stream()
                .filter(dataForResponse -> dataForResponse.getMid() < 0)
                .collect(Collectors.toList());
        listOfCalculatedDiffrencesLastQuarter.clear();
        return result;
    }

    public List<DataForResponse> getDownwardSessionsInLastQuarter(Currency userCurrency) {
        getDifferencesSessionInLastQuarter(userCurrency);

        List<DataForResponse> result = listOfCalculatedDiffrencesLastQuarter.stream()
                .filter(dataForResponse -> dataForResponse.getMid() > 0)
                .collect(Collectors.toList());
        listOfCalculatedDiffrencesLastQuarter.clear();
        return result;
    }

    public List<DataForResponse> getAllListsInOneWeek(Currency userCurrency){
        List<DataForResponse> list = new ArrayList<>();
        list.addAll(getDownwardSessionsInWeek(userCurrency));
        list.addAll(getGrowthSessionsInWeek(userCurrency));
        list.addAll(getInvariableSessionsInWeek(userCurrency));

        return list.stream()
                .sorted(Comparator.comparing(DataForResponse::getEffectiveDate))
                .collect(Collectors.toList());
    }


}
