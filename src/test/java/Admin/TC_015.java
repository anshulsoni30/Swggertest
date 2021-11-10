package Admin;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.Basetest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_015 extends Basetest{
	@Test
	public void listproductcatgory()   {
        RequestSpecification res5= given().spec(req1).pathParams("limit",2).pathParams("page",1);
		Response categoryresponse =res5.when().get(pro.getProperty("categorypath")).then().spec(resspec1).log().all().extract().response();
		
 JsonPath js=Basetest.rawToJson(categoryresponse);
 js.prettyPrint();

 Assert.assertEquals( categoryresponse.getStatusCode(),200);
 Assert.assertEquals(String.valueOf(categoryresponse.getHeader("x-pagination-limit")),String.valueOf(2));
		
		
	}

}
