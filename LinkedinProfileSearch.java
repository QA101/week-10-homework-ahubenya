import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedinProfileSearch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ahubenya/Downloads/chromedriver");
			WebDriver driver = new ChromeDriver();
	//go to google
	driver.get("http://google.com");
	//search for my name
	driver.findElement(By.id("lst-ib")).sendKeys("Angela Hubenya Linkedin");
	//click the Search button
	driver.findElement(By.name("btnK")).click(); 
	//validating its me 
	boolean pass = driver.getPageSource().contains("https://www.linkedin.com/in/angelahubenya");
	//validating failed test
	//boolean pass = driver.getPageSource().contains("https://www.linkedin.com/in/angelagalenko");
	 if (pass) {
         System.out.println("Profile found");
     } else if (!pass) {
         System.out.println("Profile not found");

     }
		
	}

}


