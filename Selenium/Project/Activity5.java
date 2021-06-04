package ProjectActivities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
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
	public void FindandClickMyInfo() {
		//Find the input fields
        WebElement UserName = driver.findElement(By.id("txtUsername"));
        WebElement Password = driver.findElement(By.id("txtPassword"));
        //Enter Username & Password
        UserName.sendKeys("orange");
        Password.sendKeys("orangepassword123");
        
      //Click Submit
        driver.findElement(By.id("btnLogin")).click();
		 //Find the MyInfo button
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
      //Click on MyInfo
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        
        
      //Click Add
        driver.findElement(By.id("btnSave")).click();	
        
      //Find the input fields
        WebElement FirstName = driver.findElement(By.id("personal_txtEmpFirstName"));
        WebElement LastName = driver.findElement(By.id("personal_txtEmpLastName"));
       
        //To Clear TextField
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        
        //Enter Username & Password
        FirstName.sendKeys("puja");
        LastName.sendKeys("sarkar");
        
        //To Select radio button to select gender
        WebElement radio1 = driver.findElement(By.id("personal_optGender_2"));
        radio1.click();
        
 
        //Select date from Datepicker calender
        selectDate("23 Jun 1991");

        //selectDate("23-06-1991");
        //selectDate("23/Jun/1991");
        //selectDate("23/06/1991");
        //selectDate("23 Jun 1991");

      }

      //Reusable Method for Selecting Date
      public void selectDate(String format){
    	  driver.findElement(By.className("ui-datepicker-trigger")).click();
       
         //identifying format
         String date[] = null;
         if(format.contains("-")){
           date =format.split("-");
         }
         else if(format.contains("/")){
            date =format.split("/");
         }
         else if(format.contains(" ")){
            date =format.split(" ");
         }
         //Splitting data
         String day=date[0];
         String month=date[1];
         String year=date[2];
       
         //Selecting data based on format
         if(month.length()==2){
          //selecting month if you are giving input format as dd-mm-yyyy
          new Select(driver.findElement(By.className("ui-datepicker-month"))).selectByIndex(Integer.parseInt(month)-1);
         }
         else if(month.length()!=2){
        //selecting month if you are giving input format as dd-mmm-yyyy
          new Select(driver.findElement(By.className("ui-datepicker-month"))).selectByVisibleText(month);
         }
         //selecting year
         new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"))).selectByVisibleText(year);
       
          //click on day
          driver.findElement(By.linkText(day)).click();
           }
      
//To Select from Dropdown 'Nationality'
      
      private void selectBy() {
    	  Select s = new Select(driver.findElement(By.name("personal[cmbNation]")));
    	  s.selectByValue("Indian");
      
    	//Click Add
          driver.findElement(By.id("btnSave")).click();	

      }
      
      
 void clear_field() {
		// TODO Auto-generated method stub
		
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}
}
