package Admin;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.Basetest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Test
public class TC_016 extends Basetest {
	SoftAssert softAssert = new SoftAssert();
public void addandupdatecategory() {
/* add category*/
	RequestSpecification res6= given().spec(req1).body(p.addcatergorypayload());
	Response addcategoryresponse =res6.when().post(pro.getProperty("addcategory")).then().spec(resspec1).log().all().extract().response();
	addcategoryresponse.prettyPrint();
	
	 JsonPath js=Basetest.rawToJson(addcategoryresponse);
	 int id=js.getInt("data.id");
	 System.out.println(id);
	 js.prettyPrint();
	 
/* get category*/
	 Response getcategoryresponse =res6.when().get(pro.getProperty("addcategory")+id).then().spec(resspec1).log().all().extract().response();
		
		JsonPath js1=Basetest.rawToJson(getcategoryresponse);
		js1.prettyPrint();
		
/* update category*/
	 RequestSpecification res7= given().spec(req1).pathParam("category_id", id).body(p.updatecatergorypayload());
	 Response updatecategoryresponse =res7.when().put(pro.getProperty("updatecateory")).then().spec(resspec1).log().all().extract().response();
	
	
	JsonPath js2=Basetest.rawToJson(updatecategoryresponse);
	js2.prettyPrint();
/*get updated response*/
	 RequestSpecification res8= given().spec(req1).pathParam("category_id", id).body(p.updatecatergorypayload());
	 Response updatedcategoryresponse =res8.when().get(pro.getProperty("updatecateory")).then().spec(resspec1).log().all().extract().response();
		
		JsonPath js3=Basetest.rawToJson(updatedcategoryresponse);
		js3.prettyPrint();
		
		 JSONObject jo=new  JSONObject(js3.prettyPrint());
		 JSONArray arr =  jo.getJSONArray("data");
		 String name="";
		 String metatitle="";
		 for (int i = 0; i < arr.length(); i++)
		 {
		    name = arr.getJSONObject(i).getString("name");
		    metatitle=arr.getJSONObject(i).getString("meta_title");
		  
		 }
		 softAssert.assertEquals(name, "Computers & Accessories sample");
		softAssert.assertEquals( metatitle, "Computers & Accessories sample");
		softAssert.assertAll();
		
		
		
		
	
	
		 
		
	
}

}
