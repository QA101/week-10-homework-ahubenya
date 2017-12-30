import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class DemoQAAutomationTest {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "/Users/ahubenya/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

	driver.get("http://demoqa.com");
	WebElement w = driver.findElement(By.partialLinkText("Registration"));
	w.click();
	if(driver.getCurrentUrl().contains("registration")) {
		System.out.println("Hey, we made it");
	}
	//Fill in first name
	driver.findElement(By.id("name_3_firstname")).sendKeys("Angela");
	//Fill in last name
	driver.findElement(By.id("name_3_lastname")).sendKeys("Hubenya");
	//Select marital status 
	List<WebElement> status = driver.findElements(By.name("radio_4[]"));
	for(WebElement w1 : status) {
		if(w1.getAttribute("value").equals ("married")) {
			w1.click();
		}
	}
	//Select Hobby checkbox 
	List<WebElement> hobby = driver.findElements(By.name("checkbox_5[]"));
	for(WebElement w1 : hobby) {
		if(w1.getAttribute("value").equals ("reading")) {
			w1.click();
		}
	}
	//Select country dropdown 
	Select country = new Select(driver.findElement(By.id("dropdown_7")));
	country.selectByValue("United States");
	//Enter date of birth 
	Select month = new Select(driver.findElement(By.id("mm_date_8")));
	month.selectByValue("10");
	Select day = new Select(driver.findElement(By.id("dd_date_8")));
	day.selectByValue("20");
	Select year = new Select(driver.findElement(By.id("yy_date_8")));
	year.selectByValue("1989");
	//Enter phone number 
	driver.findElement(By.id("phone_9")).sendKeys("2067789302");
	//Enter username 
	driver.findElement(By.id("username")).sendKeys("ahubenya");
	//Enter email address 
	driver.findElement(By.id("email_1")).sendKeys("ahubenya@gmail.com");
	//Add picture 
	driver.findElement(By.id("profile_pic_10")).sendKeys("/Users/ahubenya/Documents/ProfilePic.png");
	//Enter About me 
	driver.findElement(By.id("description")).sendKeys("Hello, my name is Angela.");
	//Enter Password 
	driver.findElement(By.id("password_2")).sendKeys("Abc1234!");
	//Confirm Password
	driver.findElement(By.id("confirm_password_password_2")).sendKeys("Abc1234!");
	
	
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		Files.copy(scrFile, new File ("/Users/ahubenya/Downloads/DemoQAScreenshot.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//driver.quit();
	}

}
