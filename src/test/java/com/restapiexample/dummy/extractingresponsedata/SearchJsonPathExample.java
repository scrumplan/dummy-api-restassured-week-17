package com.restapiexample.dummy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://dummy.restapiexample.com";
        RestAssured.basePath="/api/v1";
        response = given()
                .when()
                .get("/employees")
                .then().statusCode(200);

    }


    // 1]to verify total records are 24
    @Test
    public void test001() {
        List<String> data = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total records are  : " + data.size());
        System.out.println("------------------End of Test---------------------------");
    }
    // 2]to verify data[23].id = 24
    @Test
    public void test002() {
        int id = response.extract().path("data[23].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of data[23].id : " + id);
        System.out.println("------------------End of Test---------------------------");
    }
    //3] to verify data[23].employee_name = “Doris Wilder”"
    @Test
    public void test003() {
        String employeeName = response.extract().path("data[23].employee_name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of data[23].employee_name : " + employeeName);
        System.out.println("------------------End of Test---------------------------");
    }
    // 4] message = “Successfully! All records has beenfetched."
    @Test
    public void test004() {
        String message = response.extract().path("message");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Value message : "+ message);
        System.out.println("------------------End of Test---------------------------");
    }
    // 5] to verify status = success"
    @Test
    public void test005() {
        String status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of status :"+ status);

        System.out.println("------------------End of Test---------------------------");
    }
    // 6] to verify id = 3 has employee_salary = 86000"
    @Test
    public void test006() {
        List<String> employeeSalary = response.extract().path("data.findAll{it.id==3}.employee_salary");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of employee salary has id is 3 : " + employeeSalary);
        System.out.println("------------------End of Test---------------------------");
    }
    // 7] to verify id = 6 has employee_age = 61"
    @Test
    public void test007() {
        List<String> age= response.extract().path("data.findAll{it.id==6}.employee_age");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of employee_age has id is 6 : " + age);
        System.out.println("------------------End of Test---------------------------");
    }
    // 8] to verify  id = 11 has employee_name = Jena Gaines
    @Test
    public void test008() {
        List<String> name = response.extract().path("data.findAll{it.id==11}.employee_name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of employee_name has id is 11 : " + name);
        System.out.println("------------------End of Test---------------------------");
    }
    }


