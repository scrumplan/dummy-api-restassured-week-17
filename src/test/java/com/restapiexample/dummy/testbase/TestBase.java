package com.restapiexample.dummy.testbase;



import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase {

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "http://dummy.restapiexample.com";
        RestAssured.basePath="/api/v1";

    }
}
