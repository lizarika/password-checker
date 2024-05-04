package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

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
                log().
                all().
                when().
        header("api_ky","1234567890123456")
                .then()
                .log()
                .all()
                .statusCode(204);
}

    @Test
    public void deleteOrderByIdAndCheckResponseCodeIsBadRequest(){
        get("/test-orders/11");
        given().
                log().
                all().
                when().
                header("api_ky","1234567890123456")
                .then()
                .log()
                .all()
                .statusCode(400);
    }

}
