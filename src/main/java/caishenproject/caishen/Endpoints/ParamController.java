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

    @GetMapping("/getParamTwoWeek/{currencyFromUser}")
    public ResponseEntity<Param> getParamTwoWeek(@PathVariable String currencyFromUser){
        Currency currency = Currency.getInstance(currencyFromUser);
        return ResponseEntity.ok(new Param(paramService.twoWeekMeoan(currency),
                paramService.twoWeekDominan(currency),
                paramService.twoWeekStandardDeviation(currency),
                paramService.twoWeekCoefficientOfVariation(currency) )
        );
    }

    @GetMapping("/getParamLastMonth/{currencyFromUser}")
    public ResponseEntity<Param> getParamLastMonth(@PathVariable String currencyFromUser){
        Currency currency = Currency.getInstance(currencyFromUser);
        return ResponseEntity.ok(new Param(paramService.lastMonthMeoan(currency),
                paramService.lastWeekDominan(currency),
                paramService.lastWeekStandardDeviation(currency),
                paramService.lastWeekCoefficientOfVariation(currency) )
        );
    }

    @GetMapping("/getParamLastQuarter/{currencyFromUser}")
    public ResponseEntity<Param> getParamLastQuarter(@PathVariable String currencyFromUser){
        Currency currency = Currency.getInstance(currencyFromUser);
        return ResponseEntity.ok(new Param(paramService.lastQuarterMeoan(currency),
                paramService.lastQuarterDominan(currency),
                paramService.lastQuarterStandardDeviation(currency),
                paramService.lastQuarterCoefficientOfVariation(currency) )
        );
    }

    @GetMapping("/getParamLastHalfYear/{currencyFromUser}")
    public ResponseEntity<Param> getParamLastHalfYear(@PathVariable String currencyFromUser){
        Currency currency = Currency.getInstance(currencyFromUser);
        return ResponseEntity.ok(new Param(paramService.lastHalfYearMeoan(currency),
                paramService.lastHalfYearDominan(currency),
                paramService.lastHalfYearStandardDeviation(currency),
                paramService.lastHalfYearCoefficientOfVariation(currency) )
        );
    }

    @GetMapping("/getParamLastYear/{currencyFromUser}")
    public ResponseEntity<Param> getParamLastYear(@PathVariable String currencyFromUser){
        Currency currency = Currency.getInstance(currencyFromUser);
        return ResponseEntity.ok(new Param(paramService.lastYearMeoan(currency),
                paramService.lastYearDominan(currency),
                paramService.lastYearStandardDeviation(currency),
                paramService.lastYearCoefficientOfVariation(currency) )
        );
    }
}
