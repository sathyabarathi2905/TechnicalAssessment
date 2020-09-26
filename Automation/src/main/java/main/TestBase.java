package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase  {

	public WebDriver driver;
	public Properties p;
	public String browser;
	
	public WebDriver InstantiateDriver() throws IOException
	{
		p=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\hp\\Desktop\\Sathya\\Sathya\\TechAssessmentMaven\\src\\main\\java\\resources\\Inputs.properties");
	p.load(fis);
	browser=p.getProperty("Browser");
	if (browser.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chromedriver.driver","C:\\Users\\hp\\Desktop\\Sathya\\Sathya\\TechAssessmentMaven\\chromedriver.exe");
		driver=new ChromeDriver();	
	}
	else if(browser.equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.internetexplorerdriver.driver","C:\\Users\\hp\\Desktop\\Sathya\\Sathya\\TechAssessmentMaven\\IEDriverServerxe");
		driver=new InternetExplorerDriver();	
	}
	else if(browser.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver=new FirefoxDriver();	
	}
	driver.get("http://todomvc.com/examples/angularjs/#/");
	//driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	public void screenshotpass(String Testcasename, WebDriver driver) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\hp\\Desktop\\Sathya\\Sathya\\TechAssessmentMaven\\src\\main\\resources\\Screenshots\\"+Testcasename+"pass.png"));
	}
	public void screenshotfail(String Testcasename, WebDriver driver) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\hp\\Desktop\\Sathya\\Sathya\\TechAssessmentMaven\\src\\main\\resources\\Screenshots\\"+Testcasename+"fail.png"));
	}
}


