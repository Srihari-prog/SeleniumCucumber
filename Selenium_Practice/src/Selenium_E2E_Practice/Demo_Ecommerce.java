package Selenium_E2E_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo_Ecommerce {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/");

		WebDriverWait expWait = new WebDriverWait(driver, 10);
		expWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Fiction Books']"))).click();
		Thread.sleep(5000);

		WebElement hoverElement = driver
				.findElement(By.cssSelector("img[alt='Don\\27t believe everything you think']"));
		WebElement quickView = driver.findElement(By.xpath("//a[text()='Quick View']"));
		Actions action = new Actions(driver);
		action.moveToElement(hoverElement).click(quickView).build().perform();

		driver.findElement(By.id("btnViewProduct")).click();

		Thread.sleep(3000);
		Select option = new Select(
				driver.findElement(By.cssSelector("select[name='ctl00$phBody$ProductDetail$CartBoxWeb$ddlQty']")));
		option.selectByValue("5");

		driver.findElement(By.id("btnAddtocart")).click();

		driver.findElement(By.cssSelector("li[class='list-inline-item position-relative']")).click();

		driver.quit();

	}

}
