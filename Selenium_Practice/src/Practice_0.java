import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

public class Practice_0 {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Logging in SauceDemo web site.

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		WebElement name = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@name='login-button']"));

		name.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		Thread.sleep(2000);
		loginBtn.click();		
	
	}

}
