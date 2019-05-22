package caishenproject.caishen.Endpoints;

import caishenproject.caishen.providers.NbpProvider;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NbpTableControllerTest {

    @LocalServerPort
    int port;

    private NbpProvider nbpProvider  =  new NbpProvider();

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void getNbpTableAEndPoint() {
        given().
                contentType("application/json")
               .when()
               .get("/api/all")
               .then()
               .statusCode(200);
    }

    @Test
    public void getSessionInOneWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/oneWeek/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getSessionInTwoWeek() {

        given().
                       contentType("application/json")
               .when()
               .get("/api/twoWeek/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getSessionInLastMonth() {

        given().
                       contentType("application/json")
               .when()
               .get("/api/oneMonth/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getSessionInLastQuarter() {

        given().
                       contentType("application/json")
               .when()
               .get("/api/lastQuarter/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getSessionInLastHlafYear() {

        given().
                       contentType("application/json")
               .when()
               .get("/api/lastHalfYear/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getSessionInLastYear() {

        given().
                       contentType("application/json")
               .when()
               .get("/api/lastYear/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getDownwardSessionInOneWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/oneWeekDownward/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getGrowthSessionInOneWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/oneWeekGrowth/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getInvariableInOneWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/oneWeekInvariable/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getDownwardSessionInTwoWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/twoWeekDownward/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getGrowthSessionInTwoWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/twoWeekGrowth/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getInvariableInTwoWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/twoWeekInvariable/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getDownwardSessionInOneMonth() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/oneMonthDownward/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getGrowthSessionInOneMonth() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/oneMonthGrowth/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getInvariableInOneMonth() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/oneMonthInvariable/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getDownwardSessionInLastQuarter() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/lastQuarterDownward/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getGrowthSessionInLastQuarter() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/lastQuarterGrowth/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getInvariableInLastQuarter() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/lastQuarterInvariable/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getDownwardSessionInHalfYear() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/halfYearDownward/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getGrowthSessionInHalfYear() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/halfYearGrowth/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getInvariableInHalfYear() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/halfYearInvariable/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getDownwardSessionInLastYear() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/lastYearDownward/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getGrowthSessionInLastYear() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/lastYearGrowth/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getInvariableInLastYear() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/lastYearInvariable/USD")
               .then()
               .statusCode(200);
    }
}
