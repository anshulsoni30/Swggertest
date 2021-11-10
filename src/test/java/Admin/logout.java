package Admin;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.Basetest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Test
public class logout extends Basetest {
	public void adminlogout() {
        RequestSpecification res4= given().spec(req1);
		Response response4 =res4.when().post(pro.getProperty("logout")).then().spec(resspec1).extract().response();
        response4.prettyPrint();
        JsonPath js3= Basetest.rawToJson(response4);
        js3.prettyPrint();
        System.out.println(response4.getStatusCode());
        Assert.assertEquals(response4.getStatusCode(), 200);
	}
}
