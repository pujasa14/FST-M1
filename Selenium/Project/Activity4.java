package ProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		
	}
	
	@Test 
	public void FindandClickPIM() {
		//Find the input fields
        WebElement UserName = driver.findElement(By.id("txtUsername"));
        WebElement Password = driver.findElement(By.id("txtPassword"));
        //Enter Username & Password
        UserName.sendKeys("orange");
        Password.sendKeys("orangepassword123");
        
      //Click Submit
        driver.findElement(By.id("btnLogin")).click();
		 //Find the PIM button
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
      //Click on PIM
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        
        
        WebElement searchBtn = driver.findElement(By.id("menu_pim_viewPimModule"));

        Actions action = new Actions(driver);
        action.moveToElement(searchBtn).perform();
        
      //Click Add
        driver.findElement(By.id("btnAdd")).click();	
		
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}
}
