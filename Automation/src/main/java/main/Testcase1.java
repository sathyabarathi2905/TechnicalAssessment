package main;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.ObjectRepository;

public class Testcase1 extends TestBase{

	public WebDriver driver;
	@BeforeTest
	public void openbrowser() throws IOException
	{
		driver= InstantiateDriver();
	}
	@Test
	public void TestcaseNumber1() throws IOException
	{
		String Testcasenumber= "TestCaseNumber1";
		//store the task in a string
		String ToDo_One="Do Exercise daily";
		ObjectRepository OR=new ObjectRepository(driver);
		//add the stored task in to do list in application
		OR.Text_Field().sendKeys(ToDo_One);
		OR.Text_Field().sendKeys(Keys.ENTER);
		//check whether the above added string is matching with the input test data we send
		//if both matches then actual equal to expected
		if(OR.AddedTask().getText().equalsIgnoreCase(p.getProperty("Task1")))
		{
			Assert.assertTrue(OR.AddedTask().getText().equalsIgnoreCase(p.getProperty("Task1")));
			System.out.println("The task added matches with the input test data(which is nothing but the added task). Hence the case is pass");
			screenshotpass(Testcasenumber,driver);
		}
		else
		{
			screenshotfail(Testcasenumber,driver);
			System.out.println("The task added doesnot matches with the input test data(which is nothing but the added task). Hence the case is fail");
			Assert.assertFalse(!OR.AddedTask().getText().equalsIgnoreCase(p.getProperty("Task1")));
		}
	}
	@AfterTest
	public void closebrowser()
	{
		driver.quit();
	}
}


