package api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestApiMocked {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://backend.tallinn-learning.ee";

    }

    @Test
    public void getOrderByIdAndCheckResponseCodeIsOk(){
    get("/test-orders/9")
            .then()
            .log()
            .all()
            .statusCode(200);
    }

    @Test
    public void getOrderByInvalidIdAndCheckResponseCodeIsBadRequest(){
        given().
        when().
        get("/test-orders/11")
                .then()
                .log()
                .all()
                .statusCode(400);
    }
    @Test
    public void getAllOrdersAndCheckResponseCodeIsOk(){
        get("/test-orders/get_orders")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    //9 homework. deleting orders
    @Test
    public void deleteOrderByIdAndCheckResponseCodeIsOk(){
        get("/test-orders/9");
        given().
                header("api_key","1234567890123456").
                when().
                       delete("/test-orders/9")
                .then()
                .statusCode(204);
}


    @Test
    public void deleteOrderByIdAndCheckResponseCodeIsBadRequest(){
        get("/test-orders/11");
        given().
                log().
                all().
                when().
                header("api_key","1234567890123456")
                .then()
                .log()
                .all()
                .statusCode(400);
    }

    //10th  lesson
    @ParameterizedTest
    @ValueSource(ints = {1,9,10})
    public void getOrderByIdAndCheckResponseCodeIsOk(int orderId){
        int responseOrderId =
        given().
                log().
                all().
                when().
                get("/test-orders/" + orderId)
                //get("/test-orders/{orderId}, orderId")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract().path("id");
        Assertions.assertEquals(orderId, responseOrderId);

}


    // 10th homework
    @ParameterizedTest
    @CsvSource({
            "Name_01, Password_01",
            "Name_02, Password_02",
            "Name_03, Password_03",
            "Name_04, Password_04"
    })
    public void testWithCsvSource(String username, String password){
        String response = given().
                log()
                .all()
                .when()
                .get("/test-orders?username={username}&password={password}", username, password)
//                .get("/test-orders/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("apiKey");

        Assertions.assertNotNull(response);


    }

}
