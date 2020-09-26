package main;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.ObjectRepository;

public class Testcase2 extends TestBase{
	public WebDriver driver;
	@BeforeTest
	public void openbrowser() throws IOException
	{
		driver= InstantiateDriver();
	}
	@Test
	public void TestcaseNumber2() throws IOException
	{
		String Testcasenumber="TestCaseNumber2";
		int s=0,a,k=1;
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
		//get the total completed tasks
		s=OR.TotalCompletedTasks().size();
		//get the active tasks by subtracting total completed tasks from total tasks added
		a=TotalTaskinput-s;
		String value=Integer.toString(a);
		//compare the active tasks value with the counter value shown in the bottom left
		//if both are same then there is not error in the code. once we select the checkbox the task is completed and counter value shows the correct number of active tasks
		if(value.equalsIgnoreCase(OR.CounterValue().getText()))
		{
			k=0;
		}
		if(k==0)
		{
			Assert.assertTrue(k==0);
			screenshotpass(Testcasenumber,driver);
			System.out.println("Counter value in the bottom left is equal to active tasks left");
		}
		else
		{
			Assert.assertFalse(k==1);
			screenshotfail(Testcasenumber,driver);
			System.out.println("Counter value in the bottom left is not equal to active tasks left");
		}
		
	}
@AfterTest
public void closebrowser()
{
	driver.quit();
}
	}

