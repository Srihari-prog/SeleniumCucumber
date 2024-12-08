import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice_7 {

	public static void main(String[] args) throws InterruptedException {

		// WebDriver waits - implicit, explicit waits

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");

		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.cssSelector("[itemprop] [placeholder]")).sendKeys("Srihari");

		// explicit wait

		driver.get("https://letcode.in/waits");
		driver.findElement(By.cssSelector("#accept")).click();

		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//a[text()='Log in']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='email']")));
		driver.findElement(By.cssSelector("[name='email']")).sendKeys("Srihari");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("span[class='icon has-text-primary']")).click();
		driver.findElement(By.cssSelector(".bg.hero.is-medium > .hero-body img")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//p[@class='text-dark font-cr-regular text-sm tw-break-word'][1]")));
		System.out.println(driver
				.findElement(By.xpath("//p[@class='text-dark font-cr-regular text-sm tw-break-word'][1]")).getText());
		driver.close();

	}

}
