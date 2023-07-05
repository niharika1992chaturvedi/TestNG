package Test_Classes;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Put_API_Method;
import RequestRepoasitory.put_Req_Repoasitory;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
	@Test
	
public static void extractor() throws IOException 
{
	int statusCode = Put_API_Method.Responsestatuscode(
	put_Req_Repoasitory.BaseURI(),
	put_Req_Repoasitory.Put_Resource(),
	put_Req_Repoasitory.Put_Req_TC1());
	System.out.println(statusCode);
	
	String ResponseBody = Put_API_Method.ResponseBody (
	put_Req_Repoasitory.BaseURI(),
	put_Req_Repoasitory.Put_Resource(),
	put_Req_Repoasitory.Put_Req_TC1());
	System.out.println(ResponseBody);
	
	JsonPath JspResponse =new JsonPath(ResponseBody);
	String put_res_name=JspResponse.getString("name");
	String put_res_job=JspResponse.getString("job");
	
	
	Assert.assertEquals(put_res_name, "morpheus");
	Assert.assertEquals(put_res_job, "zion resident");
}
}