package caishenproject.caishen.providers;

import caishenproject.caishen.providers.data.DataForResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4ClassRunner.class)
public class MethodsTest {


    List<DataForResponse> dataForResponses;


    @Before
    public void setup(){
        dataForResponses = new ArrayList<>();
        dataForResponses.add(new DataForResponse(3.5,"2019-05-01"));
        dataForResponses.add(new DataForResponse(3.3,"2019-05-02"));
        dataForResponses.add(new DataForResponse(4.0,"2019-05-03"));
    }

    @Test
    public void shouldProperlyCountMedian() {
        double medianActual = Methods.getMedian(dataForResponses);
        double excpected = 3.4;

        assertThat(medianActual, is(excpected));
    }

    @Test
    public void shouldProperlyDominant() {

        double medianActual = Methods.getDominant(dataForResponses);
        double excpected = 4.0;

        assertThat(medianActual, is(excpected));
    }

    @Test
    public void shouldProperlyStandardDeviation() {
        double medianActual = Methods.getStandardDeviation(dataForResponses);
        double excpected = 0.13000000000000006;

        assertThat(medianActual, is(excpected));
    }

    @Test
    public void shouldProperlyCalculateCoefficientOfVariation() {
        double medianActual = Methods.calculateCoefficientOfVariation(dataForResponses);
        double excpected = 3.611111111111113;

        assertThat(medianActual, is(excpected));
    }
}
