package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class) //getting data provider from different class
	
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("***** Starting TC_003_LoginDDT *****");
		
		try
		{
	      //HomePage
		  HomePage hp=new HomePage(driver);
	      hp.clickMyaccount();
	      hp.clickLogin();
		
	      //Login
	        LoginPage lp=new LoginPage(driver);  
	        lp.setEmail(email);
	        lp.setPassword(pwd);
	        Thread.sleep(5000);
	        lp.clickLogin();

	        //MyAccount
	         MyAccountPage macp=new MyAccountPage(driver);
	         boolean targetPage=macp.isMyAccountPageExists();
			
		
	
	/*
	Data is valid  - login success - test pass - logout
	Data is valid - login failed - test fail

	data is in valid - login success - test fail - logout
	Data is invalid - login failed - test pass

	*/
	 
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage==true) 
		{
			macp.clickLogout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
			
	}
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetPage==true)
		{
			macp.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
		}catch(Exception e)
		{
			Assert.fail();
		}
	    logger.info("*****Finished TC_003_LoginDDT *****");
	
	
	
	
	}
	
	
}
