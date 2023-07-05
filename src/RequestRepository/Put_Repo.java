package RequestRepository;
import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Common_Utility_methods;

//class name 
public class Put_Repo { 

	//baseURI
	public static String  BaseURI() {
		String baseURI= "https://reqres.in/";
		return baseURI;
	}
	//Resource
	public static String Put_Resource() {
		String Put_Resource = "api/users";
		return Put_Resource;
	}
	//first test repoasitory
	public static String Put_Req_TC1() throws IOException {
		ArrayList<String>
		Req_Data= Common_Utility_methods.ReadDataExcel("putApi","TC1");
		System.out.println(Req_Data);
		
		//system.out,println(Req_Data);
		String Req_Name=Req_Data.get(1);
		String Req_Job=Req_Data.get(1);
		
		
		String RequestBody = "{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}" ;
		
		return RequestBody;
	}
}
