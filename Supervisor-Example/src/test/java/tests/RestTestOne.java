/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import static org.hamcrest.Matchers.*;

import tests.PropConfigurator;
import tests.ReadProperties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



/**
 *
 * @author srivathg
 */
public class RestTestOne
{
    
    public RestTestOne()
    {
            PropConfigurator.configure();
    }
    @BeforeClass
	public void initPath() 
                    {
                              ReadProperties rp = new ReadProperties();
                              //RestAssured.baseURI =  rp.getProperty("TaggingURI");
                              //RestAssured.basePath =rp.getProperty("TaggingBasePath");
		}
    @Test
    public void TestRestAssured()
    {
         /* String EndPoint="2";
          Response r = RestAssured.given().contentType(ContentType.JSON).when().body(valid).when().post(EndPoint).andReturn();
          //Response r = RestAssured.given().contentType(ContentType.JSON).when().get(EndPoint).andReturn(); 
         // Response r = RestAssured.given().contentType(ContentType.JSON).when().body(valid).when().post(EndPoint).andReturn(); 
           //Response r = RestAssured.given().contentType(ContentType.JSON).when().body(valid).when().put(EndPoint).andReturn();
          r.then().assertThat().statusCode(200);
          r.then().assertThat().contentType(ContentType.JSON);
          r.then().assertThat().body("response.entityTypeId", greaterThanOrEqualTo(1)); */
          
          //For Post request with JSON file as input
          
          //For Get request with single input
          Response getresponse = RestAssured.given().get("http://16.103.35.13:3205/r1/report/schedule/query/");
          getresponse.then().assertThat().statusCode(300);
          //System.out.println("=============================================================");
         // System.out.println(getresponse.getStatusCode());
          //System.out.println("=============================================================");
          //Request without any input

    }
    
}
