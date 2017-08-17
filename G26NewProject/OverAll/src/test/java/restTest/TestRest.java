package restTest;


import static libs.RestUtils.sendRequest;

import java.io.IOException;

import org.junit.Test;

import libs.Response;

public class TestRest {
	
	@Test
	public void testRest() throws IOException {
		Response response = sendRequest("https://api.getpostman.com/collections", "4d434e58a3d6453ca77b92891a623f5b");
		int sizeOfCollection = response.getCollections().size();
		
		System.out.println("response length = " + sizeOfCollection );
		System.out.println("All collections ->" + response.getCollections());
		
		if (sizeOfCollection > 0) {
			for (int numberInCollection = 0; numberInCollection < sizeOfCollection; numberInCollection++) {
				System.out.println("Response name"+numberInCollection+" = " + response.getCollections().get(numberInCollection).get("name"));
			}
			
		}
	}
}


