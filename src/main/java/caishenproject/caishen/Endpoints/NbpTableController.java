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

    @RequestMapping(method = RequestMethod.GET,value = "/all")
    public NbpTableA getNbpTableAEndPoint(){
        nbpProvider = new NbpProvider();
        return nbpProvider.getNbpTableA().get(0);
    }

    @GetMapping("/oneWeekDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInOneWeek(@PathVariable String currency){
        return nbpProvider.getDownwardSessionsInWeek(Currency.getInstance(currency));
    }

    @GetMapping("/oneWeekGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInOneWeek(@PathVariable String currency){
        return nbpProvider.getGrowthSessionsInWeek(Currency.getInstance(currency));
    }

    @GetMapping("/oneWeekInvariable/{currency}")
    public List<DataForResponse> getInvariableInOneWeek(@PathVariable String currency){
        return nbpProvider.getInvariableSessionsInWeek(Currency.getInstance(currency));
    }

    @GetMapping("/twoWeekDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInTwoWeek(@PathVariable String currency){
        return nbpProvider.getDownwardSessionsInTwoWeeks(Currency.getInstance(currency));
    }

    @GetMapping("/twoWeekGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInTwoWeek(@PathVariable String currency){
        return nbpProvider.getGrowthSessionsInTwoWeeks(Currency.getInstance(currency));
    }

    @GetMapping("/twoWeekInvariable/{currency}")
    public List<DataForResponse> getInvariableInTwoWeek(@PathVariable String currency){
        return nbpProvider.getInvariableSessionsInTwoWeeks(Currency.getInstance(currency));
    }

    @GetMapping("/oneMonthDownward/{currency}")
    public List<DataForResponse> getDownwardSessionInOneMonth(@PathVariable String currency){
        return nbpProvider.getDownwardSessionsInOneMonth(Currency.getInstance(currency));
    }

    @GetMapping("/oneMonthGrowth/{currency}")
    public List<DataForResponse> getGrowthSessionInOneMonth(@PathVariable String currency){
        return nbpProvider.getGrowthSessionsInOneMonth(Currency.getInstance(currency));
    }

    @GetMapping("/oneMonthInvariable/{currency}")
    public List<DataForResponse> getInvariableInOneMonth(@PathVariable String currency){
        return nbpProvider.getInvariableSessionsInOneMonth(Currency.getInstance(currency));
    }
}
