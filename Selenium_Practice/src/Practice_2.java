import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.*;


public class Practice_2 {

	public static void main(String[] args) {

		// Working on dynamic (Auto suggestion) drop-down

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://easyjet.com/en");
		
		driver.findElement(By.cssSelector("#from")).click();
		driver.findElement(By.cssSelector("#from")).sendKeys("London");
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[role='option']"));
		
		for (WebElement option : options) {
			if(option.getText().contains("Mumbai")) {
				option.click();
			}
		}
		
	}
}
