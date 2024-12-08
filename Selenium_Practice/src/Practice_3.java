import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Assert;

public class Practice_3 {

	public static void main(String[] args) throws InterruptedException {

		// Working with Alerts

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://vinothqaacademy.com/alert-and-popup/");

		// alert box
		driver.findElement(By.name("alertbox")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// dismiss alert box
		driver.findElement(By.cssSelector("[name='confirmalertbox']")).click();
		Thread.sleep(2000);
		String alertInnerText = driver.switchTo().alert().getText();
		System.out.println(alertInnerText);
		driver.switchTo().alert().dismiss();

		// Prompt alert box
		driver.findElement(By.xpath("//button[@name='promptalertbox1234']")).click();
		driver.switchTo().alert().sendKeys("Yes");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		String checkText = driver.findElement(By.id("demoone")).getText();
		Assert.assertEquals("Thanks for Liking Automation", checkText);

	}

}
