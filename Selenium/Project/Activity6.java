package ProjectActivities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	private static final WebElement FirstTest = null;
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		
	}
	
	@Test
	public void FindandClickDirectory() {
		//Find the input fields
        WebElement UserName = driver.findElement(By.id("txtUsername"));
        WebElement Password = driver.findElement(By.id("txtPassword"));
        //Enter Username & Password
        UserName.sendKeys("orange");
        Password.sendKeys("orangepassword123");
        
      //Click Submit
        driver.findElement(By.id("btnLogin")).click();
		 //Find the Directory
        driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")).isDisplayed();
        System.out.println("Element is Visible");
      //Click on Directory
        driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")).click();
        
     
        String actualTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]")).getText();
        String expectedTitle = "Search Directory";
        assertEquals(actualTitle, expectedTitle);
        System.out.println("page header is matching");
        

	}
	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}
}
