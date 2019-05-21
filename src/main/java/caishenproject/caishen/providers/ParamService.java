package caishenproject.caishen.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;

@Service
public class ParamService {

    private NbpProvider nbpProvider;

    @Autowired
    public ParamService(NbpProvider nbpProvider) {
        this.nbpProvider = nbpProvider;
    }

    public double oneWeekMeoan(Currency currency){
        return Methods.getMedian(nbpProvider.getAllListsInOneWeek(currency));
    }

    public double oneWeekDominan(Currency currency){
        return Methods.getMedian(nbpProvider.getAllListsInOneWeek(currency));
    }

    public double oneWeekStandardDeviation(Currency currency){
        return Methods.getStandardDeviation(nbpProvider.getAllListsInOneWeek(currency));
    }

    public double oneWeekCoefficientOfVariation(Currency currency){
        return Methods.calculateCoefficientOfVariation(nbpProvider.getAllListsInOneWeek(currency));
    }
}
