import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice_9 {

	public static void main(String[] args) {
		
		// File upload
		
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.west-wind.com/wconnect/wcscripts/fileupload.wwd");
		
		driver.findElement(By.xpath("//input[@id='upload']")).sendKeys("C:\\Users\\janan\\OneDrive\\Desktop\\car.jpg");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[src='/wconnect/temp/car.jpg']")));
		driver.close();

	}

}
