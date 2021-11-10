package Admin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.Basetest;
@Test 
public  class AccessToken extends Basetest {
	
	
	public void accesstoken() throws IOException {
        
	/* the resposne conatins a string which is being displayed as text and not json.  */
		RequestSpecification req1= given().spec(req).header("Authorization",pro.getProperty("basic"));
		Response response =req1.when().post(pro.getProperty("accestoken_path")).then().spec(resspec).log().all().extract().response();
        response.prettyPrint();
        
        Assert.assertEquals(response.getStatusCode(), 200);
        JsonPath js=Basetest.rawToJson(response);
        String ac=js.getString("data.access_token");
        System.out.println("Genreated accesstoken = "+ac);
        
        File file = new File("C:\\Users\\user\\eclipse-workspace\\resttest\\src\\test\\java\\Utility\\global.properties");
		 FileOutputStream op=new FileOutputStream(file);
		 pro.setProperty("bearertoken", ac);
	        pro.store(op, null);
	        op.close();
        
        
            
	}
}


