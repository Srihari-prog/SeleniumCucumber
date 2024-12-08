import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

public class Practice_13 {

	public static void main(String[] args) throws InterruptedException {

		// Multiple options select

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");

		Thread.sleep(3000);

		Select multi = new Select(driver.findElement(By.cssSelector("select#select-multiple-native")));
		List<WebElement> options = multi.getOptions();
		System.out.println(options.size());

		Actions multiSelect = new Actions(driver);
		multiSelect.keyDown(Keys.CONTROL).click(options.get(0)).click(options.get(1)).click(options.get(4));
		multiSelect.keyUp(Keys.CONTROL).build().perform();

		driver.findElement(By.xpath("//button[text()='Add']")).click();

		Thread.sleep(3000);
		driver.quit();

	}

}
