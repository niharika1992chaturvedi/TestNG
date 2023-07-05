package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Post_API_Methods;
import RequestRepoasitory.Post_Req_Repoasitory;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	@Test
	
public static void extractor() throws IOException 
{
	int statusCode = Post_API_Methods.Responsestatuscode(
	Post_Req_Repoasitory.BaseURI(),
	Post_Req_Repoasitory.Post_Resource(),
	Post_Req_Repoasitory.Post_Req_TC1());
	System.out.println(statusCode);
	
	
	String ResponseBody =Post_API_Methods.ResponseBody (
			Post_Req_Repoasitory.BaseURI(),
			Post_Req_Repoasitory.Post_Resource(),
			Post_Req_Repoasitory.Post_Req_TC1());
	System.out.println(ResponseBody);
	
	JsonPath Jput =new JsonPath(ResponseBody);
	String post_res_name=Jput.getString("name");
	String post_res_job=Jput.getString("job");
	
	
	Assert.assertEquals(post_res_name, "Jaideep");
	Assert.assertEquals(post_res_job, "Jaideep");
}
}