package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endPoints.UserEndPoints;
import api.payLoad.User;
import io.restassured.response.Response;
import api.utilities.DataProviders;
public class DDTests {

	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID, String UserName, String FirstName, String LastName, String Email, String Password, String Phone)
	{
		User userPayload= new User();
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setFirstName(FirstName);
		userPayload.setUsername(UserName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		
		Response response=UserEndPoints.createUser(userPayload);
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2, dataProvider="Usernames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String UserNames)
	{
		Response response=UserEndPoints.deleteUser(UserNames);
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
