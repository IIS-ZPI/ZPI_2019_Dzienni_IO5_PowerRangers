package caishenproject.caishen.Endpoints;


import caishenproject.caishen.providers.NbpProvider;
import caishenproject.caishen.providers.data.DataForResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import caishenproject.caishen.providers.data.NbpTableA;

import java.util.Currency;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class NbpTableController {

    private NbpProvider nbpProvider;

    @Autowired
    public NbpTableController(NbpProvider nbpProvider) {
        this.nbpProvider = nbpProvider;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public NbpTableA getNbpTableAEndPoint() {
        nbpProvider = new NbpProvider();
        return nbpProvider.getNbpTableA().get(0);
    }

    @GetMapping("/oneWeek/{currency}")
    public List<DataForResponse> getSessionInOneWeek(@PathVariable String currency) {
        return nbpProvider.getAllListsInOneWeek(Currency.getInstance(currency));
    }

    @GetMapping("/twoWeek/{currency}")
    public List<DataForResponse> getSessionInTwoWeek(@PathVariable String currency) {
        return nbpProvider.getAllListsInTwoWeek(Currency.getInstance(currency));
    }

    @GetMapping("/oneMonth/{currency}")
    public List<DataForResponse> getSessionInLastMonth(@PathVariable String currency) {
        return nbpProvider.getAllListsInLastMonthWithFilter(Currency.getInstance(currency));
    }

    @GetMapping("/lastQuarter/{currency}")
    public List<DataForResponse> getSessionInLastQuarter(@PathVariable String currency) {
        return nbpProvider.getAllListsInLastQuarterWithFilter(Currency.getInstance(currency));
    }

    @GetMapping("/lastHalfYear/{currency}")
    public List<DataForResponse> getSessionInLastHlafYear(@PathVariable String currency) {
        return nbpProvider.getAllListsInHalfYearWithFilter(Currency.getInstance(currency));
    }

    @GetMapping("/lastYear/{currency}")
    public List<DataForResponse> getSessionInLastYear(@PathVariable String currency) {
        return nbpProvider.getAllListsInLastYearWithFilter(Currency.getInstance(currency));
    }

    @GetMapping("/oneWeekDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInOneWeek(@PathVariable String currency) {
        return nbpProvider.getDownwardSessionsInWeek(Currency.getInstance(currency));
    }

    @GetMapping("/oneWeekGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInOneWeek(@PathVariable String currency) {
        return nbpProvider.getGrowthSessionsInWeek(Currency.getInstance(currency));
    }

    @GetMapping("/oneWeekInvariable/{currency}")
    public List<DataForResponse> getInvariableInOneWeek(@PathVariable String currency) {
        return nbpProvider.getInvariableSessionsInWeek(Currency.getInstance(currency));
    }

    @GetMapping("/twoWeekDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInTwoWeek(@PathVariable String currency) {
        return nbpProvider.getDownwardSessionsInTwoWeeks(Currency.getInstance(currency));
    }

    @GetMapping("/twoWeekGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInTwoWeek(@PathVariable String currency) {
        return nbpProvider.getGrowthSessionsInTwoWeeks(Currency.getInstance(currency));
    }

    @GetMapping("/twoWeekInvariable/{currency}")
    public List<DataForResponse> getInvariableInTwoWeek(@PathVariable String currency) {
        return nbpProvider.getInvariableSessionsInTwoWeeks(Currency.getInstance(currency));
    }

    @GetMapping("/oneMonthDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInOneMonth(@PathVariable String currency) {
        return nbpProvider.getDownwardSessionsInOneMonth(Currency.getInstance(currency));
    }

    @GetMapping("/oneMonthGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInOneMonth(@PathVariable String currency) {
        return nbpProvider.getGrowthSessionsInOneMonth(Currency.getInstance(currency));
    }

    @GetMapping("/oneMonthInvariable/{currency}")
    public List<DataForResponse> getInvariableInOneMonth(@PathVariable String currency) {
        return nbpProvider.getInvariableSessionsInOneMonth(Currency.getInstance(currency));
    }

    @GetMapping("/lastQuarterDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInLastQuarter(@PathVariable String currency) {
        return nbpProvider.getDownwardSessionsInLastQuarter(Currency.getInstance(currency));
    }

    @GetMapping("/lastQuarterGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInLastQuarter(@PathVariable String currency) {
        return nbpProvider.getGrowthSessionsInLastQuarter(Currency.getInstance(currency));
    }

    @GetMapping("/lastQuarterInvariable/{currency}")
    public List<DataForResponse> getInvariableInLastQuarter(@PathVariable String currency) {
        return nbpProvider.getInvariableSessionsInLastQuarter(Currency.getInstance(currency));
    }


    @GetMapping("/halfYearDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInHalfYear(@PathVariable String currency) {
        return nbpProvider.getDownwardSessionsHalfYear(Currency.getInstance(currency));
    }

    @GetMapping("/halfYearGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInHalfYear(@PathVariable String currency) {
        return nbpProvider.getGrowthSessionsHalfYear(Currency.getInstance(currency));
    }

    @GetMapping("/halfYearInvariable/{currency}")
    public List<DataForResponse> getInvariableInHalfYear(@PathVariable String currency) {
        return nbpProvider.getInvariableSessionsInHalfYear(Currency.getInstance(currency));
    }

    @GetMapping("/lastYearDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInLastYear(@PathVariable String currency) {
        return nbpProvider.getDownwardSessionsLastYear(Currency.getInstance(currency));
    }

    @GetMapping("/lastYearGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInLastYear(@PathVariable String currency) {
        return nbpProvider.getGrowthSessionsLastYear(Currency.getInstance(currency));
    }

    @GetMapping("/lastYearInvariable/{currency}")
    public List<DataForResponse> getInvariableInLastYear(@PathVariable String currency) {
        return nbpProvider.getInvariableSessionsLastYear(Currency.getInstance(currency));
    }

    @GetMapping("/distributionOfQuarterChanges/{currencyFirst}/{currencySecond}")
    public List<DataForResponse> distributionOfQuarterChangesBetweenTwoCurrencies(@PathVariable String currencyFirst,@PathVariable String currencySecond) {
        return nbpProvider.distributionOfQuarterChangesBetweenTwoCurrencies(Currency.getInstance(currencyFirst.toUpperCase()),Currency.getInstance(currencySecond.toUpperCase()));
    }

    @GetMapping("/distributionOfMonthlyChanges/{currencyFirst}/{currencySecond}")
    public List<DataForResponse> distributionOfMonthlyChangesBetweenTwoCurrencies(@PathVariable String currencyFirst,@PathVariable String currencySecond) {
        return nbpProvider.distributionOfMonthlyChangesBetweenTwoCurrencies(Currency.getInstance(currencyFirst.toUpperCase()),Currency.getInstance(currencySecond.toUpperCase()));
    }
}
