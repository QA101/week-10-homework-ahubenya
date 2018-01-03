
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class ExpediaSearch {

		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "/Users/ahubenya/Downloads/chromedriver");
				WebDriver driver = new ChromeDriver();
		//go to google
		driver.get("http://expedia.com/");
		//Search From city 
		driver.findElement(By.id("package-origin-hp-package")).sendKeys("Seattle, WA (SEA-Seattle - Tacoma Intl.)");
		//Search To city 
		driver.findElement(By.id("package-destination-hp-package")).sendKeys("Puerto Vallarta, Mexico");
		//Start date
		driver.findElement(By.id("package-departing-hp-package")).sendKeys("03/08/2018");
		//End date
		driver.findElement(By.id("package-returning-hp-package")).click();
		driver.findElement(By.id("package-returning-hp-package")).clear();
		driver.findElement(By.id("package-returning-hp-package")).sendKeys("03/18/2018");
		
		//Search button 
		driver.findElement(By.id("search-button-hp-package")).click();
		//Waiting for element 
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-sort")));
		  
		//Sort by price 
		List<WebElement> list = driver.findElements(By.className("btn-sort"));
		list = driver.findElements(By.className("btn-sort"));
		for(WebElement el:list) {
			if(el.getText().equals("Price")) {
				el.click();
			}
		}
	}
}
	