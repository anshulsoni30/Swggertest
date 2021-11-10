package Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Basetest {
	public 	 RequestSpecification req;
    public  ResponseSpecification resspec;
	public Properties pro =new Properties();
	public Payload p=new Payload();
	public FileOutputStream op;
	public 	 RequestSpecification req1;
    public  ResponseSpecification resspec1;
    
    

    @BeforeTest
    public void setUp() throws IOException {
    	        System.out.println("The test started");
    	        File file = new File("C:\\Users\\user\\eclipse-workspace\\resttest\\src\\test\\java\\Utility\\global.properties");
    	        
    	        FileInputStream fis =new FileInputStream(file);
    	        pro.load(fis);
    	        fis.close();
    	        
    	        FileOutputStream op=new FileOutputStream(file);
    	        pro.store(op, null);
    	        op.close();
    	     
    	        RestAssured.baseURI=pro.getProperty("base_url"); 
    	    }
      
    

    @AfterTest
    public void tearDown() {
        System.out.println("This test is completed");
    }
     
  public static  JsonPath rawToJson(Response r)
    {
        String respon=r.asString();
        JsonPath x= new JsonPath(respon.substring(respon.indexOf('{')));
        return x;
    }
 
 @BeforeClass
  public void Admin() throws IOException {

             req = new RequestSpecBuilder().setBaseUri(pro.getProperty("base_url")).setContentType(ContentType.JSON).setAccept(ContentType.JSON).build();

             resspec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

        }
 @BeforeClass
 public void commonrequest()throws IOException {
	  req1 = new RequestSpecBuilder().setBaseUri(pro.getProperty("base_url")).setContentType(ContentType.JSON).setAccept(ContentType.JSON).addHeader("Authorization","Bearer "+pro.getProperty("bearertoken")).build();

      resspec1 = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
 }
 


 

}
