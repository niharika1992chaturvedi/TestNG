package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Patch_API_methods;
import RequestRepoasitory.Post_Req_Repoasitory;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 { 
	@Test
	
public static void extractor() throws IOException 
{
	int statusCode = Patch_API_methods.Responsestatuscode(
	Post_Req_Repoasitory.BaseURI(),
	Post_Req_Repoasitory.Post_Resource(),
	Post_Req_Repoasitory.Post_Req_TC1());
	System.out.println(statusCode);
	
	
	String ResponseBody =Patch_API_methods.ResponseBody (
			Post_Req_Repoasitory.BaseURI(),
			Post_Req_Repoasitory.Post_Resource(),
			Post_Req_Repoasitory.Post_Req_TC1());
	System.out.println(ResponseBody);
	
	JsonPath Jput =new JsonPath(ResponseBody);
	String Patch_res_name=Jput.getString("name");
	String Patch_res_job=Jput.getString("job");
	
	
	Assert.assertEquals(Patch_res_name, "name");
	Assert.assertEquals(Patch_res_job, "job");
}
}