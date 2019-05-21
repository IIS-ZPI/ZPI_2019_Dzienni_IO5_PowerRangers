package caishenproject.caishen.Endpoints;

import caishenproject.caishen.providers.ParamService;
import caishenproject.caishen.providers.data.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ParamController {

    private ParamService paramService;

    @Autowired
    public ParamController(ParamService paramService) {
        this.paramService = paramService;
    }

    @GetMapping("/getParamOneWeek/{currencyFromUser}")
    public ResponseEntity<Param> getParamOneWeek(@PathVariable String currencyFromUser){
        Currency currency = Currency.getInstance(currencyFromUser);
        return ResponseEntity.ok(new Param(paramService.oneWeekMeoan(currency),
                paramService.oneWeekDominan(currency),
                paramService.oneWeekStandardDeviation(currency),
                paramService.oneWeekCoefficientOfVariation(currency) )
        );
    }
}