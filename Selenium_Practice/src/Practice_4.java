import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Practice_4 {

	public static void main(String[] args) throws InterruptedException {

		// Handling frames, nested frames

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");

		driver.switchTo().frame(driver.findElement(By.cssSelector("#singleframe")));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

		driver.switchTo().frame(driver.findElement(By.cssSelector("[style='float: left;height: 300px;width:600px']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("[style='float: left;height: 250px;width: 400px']")));
		driver.findElement(By.cssSelector("[type='text']")).sendKeys("World");

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Home']")).click();

		driver.quit();

	}

}
