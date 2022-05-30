package com.restapiexample.dummy.myfirsttest;


import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


/**
 * Created by Jay Vaghani
 */
public class MyFirstTest extends TestBase {

    @Test
    public void getAllRestApiInfo() {

        Response response = given()
                .when()
                .get("/employees");
        response.then().statusCode(200);
        response.prettyPrint();


    }

}
