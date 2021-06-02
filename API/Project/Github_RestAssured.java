package Activities;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalTo;

public class Github_RestAssured {
    // Set base URL
    final static String ROOT_URI = "https://api.github.com/user/keys";
    final static String Base_URI = "https://api.github.com";
    String key="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC1OGtxewYHfpUpf5wElh1toeVz9fGngwa3zf3MnqhquGVBPtBxJabUeQ77BjezzY6sZy6W82pnMXMgWrtH9/dpc/2+u7xB5sjMkvEQhRhzXy8b4JcCu37nSdhwJBtWGvJhdlnYo/rH3hnPUw5sWBdVNcdB6LY5YX7JN67wYY1xDTc0bDVKVHFxAqMvY3dGEpLxzHP+H+cMRYn6Z79p45M/nabtcniPKvd7/I3C9juMrLWBaRcI1/y+QWym5DKwciUTqOftgnYvOXhaN5vm3bT2bTSCDs6zMKnL4OBFfAP7rCvHQJx1SDF6X1qlqwdXGqQxF042wrCYKR7saKkUeMtT";
	String token="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";
	int keyID=0;
	// Declare request specification
	RequestSpecification requestSpec;
	 
	
	@BeforeClass
	public void setUp() {
	    // Create request specification
	    requestSpec = new RequestSpecBuilder()
	    	.setContentType(ContentType.JSON)
	    	.addHeader("Authorization", "Bearer "+token)
	        .setBaseUri(Base_URI)
	        .build();
	    
	   
	}
	@Test(priority=1)
    public void POST() {
    	
		String reqBody="{"+
		"\"title\":\"TestGit123333\","+
				"\"key\":\"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC1OGtxewYHfpUpf5wElh1toeVz9fGngwa3zf3MnqhquGVBPtBxJabUeQ77BjezzY6sZy6W82pnMXMgWrtH9/dpc/2+u7xB5sjMkvEQhRhzXy8b4JcCu37nSdhwJBtWGvJhdlnYo/rH3hnPUw5sWBdVNcdB6LY5YX7JN67wYY1xDTc0bDVKVHFxAqMvY3dGEpLxzHP+H+cMRYn6Z79p45M/nabtcniPKvd7/I3C9juMrLWBaRcI1/y+QWym5DKwciUTqOftgnYvOXhaN5vm3bT2bTSCDs6zMKnL4OBFfAP7rCvHQJx1SDF6X1qlqwdXGqQxF042wrCYKR7saKkUeMtT\"}";
		 
		 System.out.println(reqBody);
		        Response response = 
		            given().contentType(ContentType.JSON) // Set headers
		            .header("Authorization", "Bearer "+token)
		            .body(reqBody) // Add request body
		            .when().post(ROOT_URI);
		        System.out.println(response.asPrettyString());
		        keyID=response.jsonPath().getInt("id");
		        System.out.println(keyID);
        // Assertions
        response.then().statusCode(201);
       // 
    }

	/*@Test (priority=2)
    public void GET() {
     
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
           .header("Authorization", "Bearer "+token)
           .log().all()
            .when().get(ROOT_URI); // Run GET request
        String responseBody = response.getBody().asString();
       System.out.println("Response Body is =>  " + responseBody);
         // (responseBody);
        // Assertions
        response.then().statusCode(200);
       // response.then().body("[0].status", equalTo("sold"));
    }
    @Test(priority=3)
    public void Delete() throws IOException {
    	Response response = 
                given().contentType(ContentType.JSON) // Set headers
                .header("Authorization", "Bearer "+token)
                .log().all()
                .pathParam("keyID", keyID) // Add path parameter
                .when().delete(ROOT_URI + "/{keyID}"); // Send POST request
    	            // Assertion
         response.then().statusCode(204);
    }*/
}