package caishenproject.caishen.Endpoints;

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
public class ParamControllerTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void getParamOneWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/getParamOneWeek/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getParamTwoWeek() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/getParamTwoWeek/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getParamLastMonth() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/getParamLastMonth/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getParamLastQuarter() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/getParamLastQuarter/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getParamLastHalfYear() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/getParamLastHalfYear/USD")
               .then()
               .statusCode(200);
    }

    @Test
    public void getParamLastYear() {
        given().
                       contentType("application/json")
               .when()
               .get("/api/getParamLastYear/USD")
               .then()
               .statusCode(200);
    }
}
