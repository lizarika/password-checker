package api;

import com.google.gson.Gson;
import dto.OrderDtoMocked;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.RandomDataGenerator;

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

    //11th lesson
    @Test
    public void createOrderDtoMockedAndCheckResponseCodeIsOK(){
        //OrderDtoMocked orderDtoMocked = new OrderDtoMocked("OPEN", 0, "customer", "55005500", "orderComment", 0);

        OrderDtoMocked orderDtoMocked = new OrderDtoMocked();



        orderDtoMocked.setStatus("OPEN");
        orderDtoMocked.setCourierId(0);
        orderDtoMocked.setCustomerName(RandomDataGenerator.generateName());
        orderDtoMocked.setCustomerPhone(RandomDataGenerator.generatePhone());
        orderDtoMocked.setComment(RandomDataGenerator.generateComment());
        orderDtoMocked.setId(3);

        given().
                header("Content-Type", "application/json").
                log().
                all().
                when().
                body( new Gson().toJson(orderDtoMocked) ).
                post("/test-orders/").
                then().
                log().
                all().
                statusCode(HttpStatus.SC_OK);

    }

    @Test
        public void createPUTOrderDtoMockedAndCheckResponseCodeIsOK(){
        //OrderDtoMocked orderDtoMocked = new OrderDtoMocked("OPEN", 0, "customer", "55005500", "orderComment", 0);

        OrderDtoMocked orderDtoMocked = new OrderDtoMocked();



        orderDtoMocked.setStatus("OPEN");
        orderDtoMocked.setCourierId(1);
        orderDtoMocked.setCustomerName(RandomDataGenerator.generateName());
        orderDtoMocked.setCustomerPhone(RandomDataGenerator.generatePhone());
        orderDtoMocked.setComment(RandomDataGenerator.generateComment());
        orderDtoMocked.setId(2);


        given().
                header("accept", "application/json").
                header("api-key", "1234567890123456").
                contentType(ContentType.JSON).
                log().
                all().
                when().
                body( new Gson().toJson(orderDtoMocked) ).
                put("/test-orders/{OrderId}", 2).
                then().
                log().
                all()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("status");

    }


}
