package Admin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.Basetest;

@Test
public class Adminlogin extends Basetest{
	SoftAssert softassert = new SoftAssert();
	
	public void adminlogin() throws IOException {
		/* admin login */
		RequestSpecification req2= given().spec(req1).body(p.login_payload());
		Response response2 =req2.when().post(pro.getProperty("loginendpoint")).then().spec(resspec).log().all().extract().response();
   
    System.out.println(response2.getStatusCode());
        JsonPath js1= Basetest.rawToJson(response2);
        String username=js1.getString("username");
        softassert.assertEquals(response2.getStatusCode(), 200);
        softassert.assertEquals(username,"upskills_admin");
        js1.prettyPrint();
	
	System.out.println("Admin logged in");
	

/* user account details*/
        RequestSpecification res3= given().spec(req1);
        System.out.println("getting user data");
		Response response3 =res3.when().get(pro.getProperty("adminuser")).then().spec(resspec1).log().all().extract().response();
        
        
        System.out.println(response3.getStatusCode());

        JsonPath js2= Basetest.rawToJson(response3);
        String username1=js2.getString("data.username");
        Assert.assertEquals(response3.getStatusCode(), 200);
        Assert.assertEquals(username1,"upskills_admin");
        js2.prettyPrint();
       
     
/* logout will fail the other testcases as to perfrom the test login is needed*/
       /* RequestSpecification res4= given().spec(req1);
		Response response4 =res4.when().post(pro.getProperty("logout")).then().spec(resspec1).extract().response();
        response4.prettyPrint();
        JsonPath js3= Basetest.rawToJson(response4);
        js3.prettyPrint();
        System.out.println(response4.getStatusCode());
        softassert.assertEquals(response4.getStatusCode(), 200);
	*/
}}



