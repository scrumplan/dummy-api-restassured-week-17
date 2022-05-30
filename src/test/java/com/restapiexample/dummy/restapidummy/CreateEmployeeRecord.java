package com.restapiexample.dummy.restapidummy;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateEmployeeRecord extends TestBase {
    @Test
    public void createUserPageRecord(){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("jashmee ponaa");
        employeePojo.setSalary(55000);
        employeePojo.setAge(24);

        Response response = given()
                .header("Content-Type","application/json")
                .body(employeePojo)
                .when()
                .post("/create");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
