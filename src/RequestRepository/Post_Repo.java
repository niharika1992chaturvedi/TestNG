package RequestRepository;
import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Common_Utility_methods;
import Common_API_Methods.Common_Utility_methods;
//class name 
public class Post_Repo { 

	//baseURI
	public static String  BaseURI() {
		String baseURI= "https://reqres.in/";
		return baseURI;
	}
	//Resource
	public static String Post_Resource() {
		String Post_Resource = "api/users";
		return Post_Resource;
	}
	//first test repoasitory
	public static String Post_Req_TC1() throws IOException {
		ArrayList<String>
		Req_Data= Common_Utility_methods.ReadDataExcel("PostApi","TC1");
		System.out.println(Req_Data);
		
		//system.out,println(Req_Data);
		String Req_Name=Req_Data.get(1);
		String Req_Job=Req_Data.get(1);
		
		
		String RequestBody = "\n"
				+ "{\n"
				+ "    \"name\": \""+Req_Name+"\",\r\n"
				+ "    \"job\": \""+Req_Job+"\"\r\n"
				+ "}";
		return RequestBody;
	}
	
}
