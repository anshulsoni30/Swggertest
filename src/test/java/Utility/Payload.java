package Utility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import resources.Excel;


public class Payload {
	Gson g= new Gson();
	public  String login_payload() throws IOException {
		resources.Excel d = new Excel();
        ArrayList<String> data = d.getData("Adminlogin", "Sheet1");
        
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("username", data.get(1));
        hm.put("password", data.get(2));
        return g.toJson(hm);
	}
	
public String addcatergorypayload() {
	String addcategorypayload ="{\r\n"
			+ "\"category_description\": [\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Computers & Accessories\",\r\n"
			+ "      \"meta_title\": \"Computers & Accessories\",\r\n"
			+ "      \"description\": \"Description of the Computers & Accessories\"\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";
	return addcategorypayload;
}
public String updatecatergorypayload() {
	String updatecategory="{\r\n"
			+ "\"category_description\": [\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"Computers & Accessories sample\",\r\n"
			+ "      \"meta_title\": \"Computers & Accessories sample\",\r\n"
			+ "      \"language_id\": 1\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";
	return updatecategory;
	
}
}
