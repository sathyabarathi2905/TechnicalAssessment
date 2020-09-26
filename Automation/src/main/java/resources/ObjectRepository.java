package resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepository {

	public WebDriver driver;
	public ObjectRepository(WebDriver driver)
	{
		this.driver=driver;
	}
	By TextField= By.xpath("//input[@ng-disabled='saving']");
	public WebElement Text_Field()
	{
		return driver.findElement(TextField);
	}

	By Added_Task= By.xpath("//label[@class='ng-binding']");
	public WebElement AddedTask()
	{
		return driver.findElement(Added_Task);
	}
	
	public WebElement checkbox(int i)
	{
		By check_box= By.xpath("/html/body/ng-view/section/section/ul/li["+i+"]/div/input");
		return driver.findElement(check_box);
	}
	By Counter= By.xpath("//strong[@class='ng-binding']");
	public WebElement CounterValue()
	{
		return driver.findElement(Counter);
	}
	//label[@class='ng-binding
	
	By Total_ActiveTasks= By.xpath("//li[@class='ng-scope']");
	public List<WebElement> TotalActiveTasks()
	{
		return driver.findElements(Total_ActiveTasks);
	}
	By Total_CompletedTasks= By.xpath("//li[@class='ng-scope completed']");
	public List<WebElement> TotalCompletedTasks()
	{
		return driver.findElements(Total_CompletedTasks);
	}
	
	By First_task= By.xpath("/html/body/ng-view/section/section/ul/li[1]/div/label");
	public WebElement Firsttask()
	{
		return driver.findElement(First_task);
	}
	By total_task= By.xpath("/html/body/ng-view/section/section/ul/li");
	public List<WebElement> totaltask()
	{
		return driver.findElements(total_task);
	}
	By delete_button= By.xpath("/html/body/ng-view/section/section/ul/li[1]/div/button");
	public WebElement deletebutton()
	{
		return driver.findElement(delete_button);
	}
	By Active_button= By.xpath("//a[contains(text(),'Active')]");
	public WebElement Activebutton()
	{
		return driver.findElement(Active_button);
	}
	By Completed_button= By.xpath("//a[contains(text(),'Completed')]");
	public WebElement Completedbutton()
	{
		return driver.findElement(Completed_button);
	}
}


