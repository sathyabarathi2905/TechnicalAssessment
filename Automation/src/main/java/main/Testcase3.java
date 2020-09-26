package main;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.ObjectRepository;

public class Testcase3 extends TestBase{
	public WebDriver driver;
	@BeforeTest
	public void openbrowser() throws IOException
	{
		driver= InstantiateDriver();
	}
	@Test
	public void TestcaseNumber3() throws IOException, InterruptedException
	{
		String Testcasenumber="TestCaseNumber3";
		int k=0;
		ObjectRepository OR= new ObjectRepository(driver);
		//First get the total number of tasks to be added
		int TotalTaskinput= Integer.parseInt(p.getProperty("totaltaskinput"));
		for (int i=1;i<=TotalTaskinput;i++)
		{
		OR.Text_Field().sendKeys("task Number"+ i);
		OR.Text_Field().sendKeys(Keys.ENTER);
		}
		//delete the first task in the list
		Actions a =new Actions(driver);
		a.moveToElement(OR.Firsttask()).build().perform();
		a.moveToElement(OR.deletebutton()).click().build().perform();
		//compare the 1st task with all the remaining tasks
		for(int j=0;j<OR.totaltask().size();j++)
		{
			String task=OR.totaltask().get(j).getText();
			
			if(task.equalsIgnoreCase("task Number1"))
			{
				k=1;
			}
			
		}
		//if 1st task is not equal to any other task in list then the task is deleted the case is pass
		//if 1st task is equal to any other task in list then the task is not deleted the case is fail
		if(k==0)
		{
			Assert.assertTrue(k==0);
			screenshotpass(Testcasenumber,driver);
			System.out.println("The task is deleted. hence the case is pass");
		}
		else
		{
			screenshotfail(Testcasenumber,driver);
			Assert.assertFalse(k==1);
			System.out.println("The task is not deleted. hence the case is fail");
		}
		
	}
@AfterTest
public void closebrowser()
{
	driver.quit();
}
	}
