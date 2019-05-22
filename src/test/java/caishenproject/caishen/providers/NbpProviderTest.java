package caishenproject.caishen.providers;

import caishenproject.caishen.providers.data.DataForResponse;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.Currency;
import java.util.List;

import static org.junit.Assert.assertThat;

@RunWith(JUnit4ClassRunner.class)
public class NbpProviderTest {

    private NbpProvider nbpProvider = new NbpProvider();


    @Test
    public void shouldProperlyCountInvariableSessionsInWeek() {

        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getInvariableSessionsInWeek(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(8));
    }

    @Test
    public void shouldProperlyCountInvariableSessionsInTwoWeeks() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getInvariableSessionsInTwoWeeks(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(16));
    }

    @Test
    public void shouldProperlyCountInvariableSessionsInOneMonth() {

        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getInvariableSessionsInOneMonth(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(32));
    }

    @Test
    public void shouldProperlyCountInvariableSessionsInHalfYear() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getInvariableSessionsInHalfYear(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(32*6));
    }

    @Test
    public void shouldProperlyCountInvariableSessionsLastYear() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getInvariableSessionsLastYear(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(32*12));
    }

    @Test
    public void shouldProperlyCountDownwardSessionsInWeek() {

        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getDownwardSessionsInWeek(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(8));
    }

    @Test
    public void shouldProperlyCountGrowthSessionsInWeek() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getDownwardSessionsInTwoWeeks(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(16));
    }

    @Test
    public void shouldProperlyCountDownwardSessionsHalfYear() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getDownwardSessionsHalfYear(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(32*6));
    }

    @Test
    public void shouldProperlyCountGrowthSessionsHalfYear() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getGrowthSessionsHalfYear(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(32*6));
    }

    @Test
    public void shouldProperlyCountDownwardSessionsInTwoWeeks() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getDownwardSessionsInTwoWeeks(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(16));
    }

    @Test
    public void shouldProperlyCountGrowthSessionsInTwoWeeks() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getGrowthSessionsInTwoWeeks(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(16));
    }

    @Test
    public void shouldProperlyCountDownwardSessionsInOneMonth() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getDownwardSessionsInOneMonth(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(32));
    }

    @Test
    public void shouldProperlyCountGrowthSessionsInOneMonth() {
        List<DataForResponse> actualProviderInvariableSessionsInWeek = nbpProvider.getGrowthSessionsInOneMonth(Currency.getInstance("USD"));

        assertThat(actualProviderInvariableSessionsInWeek.size(), Matchers.lessThan(32));
    }
}
