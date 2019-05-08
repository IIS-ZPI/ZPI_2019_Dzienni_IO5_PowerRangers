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
}
