package main;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.ObjectRepository;

public class Testcase4 extends TestBase{
	public WebDriver driver;
	@BeforeTest
	public void openbrowser() throws IOException
	{
		driver= InstantiateDriver();
	}
	@Test
	public void TestcaseNumber4() throws IOException, InterruptedException
	{
		String Testcasenumber="TestCaseNumber4";
		int k=0;
		ObjectRepository OR= new ObjectRepository(driver);
		//First get the total number of tasks to be added
		int TotalTaskinput= Integer.parseInt(p.getProperty("totaltaskinput"));
		for (int i=1;i<=TotalTaskinput;i++)
		{
		OR.Text_Field().sendKeys("task Number"+ i);
		OR.Text_Field().sendKeys(Keys.ENTER);
		}
		//make few tasks as completed by clicking the checkbox
		int CompletedInput= Integer.parseInt(p.getProperty("completedinput"));
		for(int j=1;j<=CompletedInput;j++)
		{
			OR.checkbox(j).click();
		}
		//calculate total active from the full list
		int AtciveFromTotalList=OR.TotalActiveTasks().size();
		//calculate total completed from the full list
		int CompletedFromTotalList=OR.TotalCompletedTasks().size();
		//click active button and calculate the total tasks
		OR.Activebutton().click();
		int Active =OR.totaltask().size();
		//click completed button and calculate the total tasks
		OR.Completedbutton().click();
		int Completed=OR.totaltask().size();
		//compare above calculated active tasks with active task calculated from total list
		//compare above calculated completed tasks with completed task calculated from total list 
		//if both are true then active cases and completed tasks are displaying correctly
		if(Active==AtciveFromTotalList&&Completed==CompletedFromTotalList)
		{
			k=1;
		}
		if(k==1)
		{
			Assert.assertTrue(k==1);
			screenshotpass(Testcasenumber,driver);
			System.out.println("Active and Completed tasks are displaying correctly");
		}
		else
		{
			screenshotfail(Testcasenumber,driver);
			System.out.println("Active and Completed tasks are not displaying correctly");
			Assert.assertFalse(k==0);
		}
	}
	@AfterTest
public void closebrowser()
{
	driver.quit();
}
	}
