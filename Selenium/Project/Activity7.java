package ProjectActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Activity7 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		
	}

	/*@Test (priority = 0)
	public void toGetTitle() {
		// Check the title of the page
		String title = driver.getTitle();
		// Print the title of the page
		System.out.println("Page title is: " + title);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

		// Get the url of the header image
		WebElement OrangeHRMLink = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		System.out.println(OrangeHRMLink.getAttribute("src"));
	}*/
	
	@Test 
	public void FindandClickMyInfo() {
		//Find the input fields
        WebElement UserName = driver.findElement(By.id("txtUsername"));
        WebElement Password = driver.findElement(By.id("txtPassword"));
        //Enter Username & Password
        UserName.sendKeys("orange");
        Password.sendKeys("orangepassword123");
        
      //Click Submit
        driver.findElement(By.id("btnLogin")).click();
       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		 //Find the MyInfo button
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
      //Click on MyInfo
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        
      //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        
      //Click on Qualification
       driver.findElement(By.xpath("//a[text()='Qualifications']")).click();
        
	}
	//@AfterMethod
	//public void afterMethod() {
		// Close the browser
		//driver.quit();
	//}
}
