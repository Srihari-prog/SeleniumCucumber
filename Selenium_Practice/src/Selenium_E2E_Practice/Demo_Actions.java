package Selenium_E2E_Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Demo_Actions {

	public static void main(String[] args) {
		
		// Select and action class
		
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		Select options = new Select(driver.findElement(By.cssSelector("[value='Running Shoes']")));
		
		List<WebElement> multiple = options.getOptions();
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.SHIFT).click(multiple.get(0)).click(multiple.get(1)).click(multiple.get(2));
		action.keyUp(Keys.SHIFT).build().perform();
		
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		
		driver.quit();
		

	}

}
