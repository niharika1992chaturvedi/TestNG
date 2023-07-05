package RequestRepository;

//class name 
public class Patch_Repo { 

	//baseURI
	public static String  BaseURI() {
		String baseURI= "https://reqres.in/";
		return baseURI;
	}
	//Resource
	public static String Patch_Resource() {
		String Patch_Resource = "api/users/2";
		return Patch_Resource;
	}
	//first test repoasitory
	public static String Post_Req_TC1() {
		
		String RequestBody = "{\n"
				+ "			    \"name\": \"morpheus\",\n"
				+ "			    \"job\": \"zion resident\",\n"
				+ "			    \"updatedAt\": \"2023-06-08T20:00:23.271Z\"\n"
				+ "			"
				+ "}";
		return RequestBody;
	}
}
