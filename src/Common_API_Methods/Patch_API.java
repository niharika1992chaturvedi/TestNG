package Common_API_Methods;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

public class Patch_API{
	
public static int Responsestatuscode(String BaseURI ,String Resource, String RequestBody) {
		
RestAssured.baseURI = BaseURI;

        
 int statuscode  = given().header("Content-Type", "application/json").body(RequestBody).
                when().patch(Resource).then().extract().statusCode();
 return statuscode;
		
	}


public static String ResponseBody(String BaseURI ,String Resource, String RequestBody) {
	
RestAssured.baseURI = BaseURI;

    
String ResponseBody  = given().header("Content-Type", "application/json").body(RequestBody).
            when().patch(Resource).then().extract().response().asPrettyString();
return ResponseBody;

}


 

} 


