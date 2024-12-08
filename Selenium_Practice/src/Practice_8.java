import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice_8 {

	public static void main(String[] args) {

		// javaScript executor

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4750)", "");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='action-inner']")));
		driver.findElement(By.cssSelector("span[class='action-inner']")).click();

		driver.close();
	}

}
