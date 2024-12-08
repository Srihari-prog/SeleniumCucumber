package Selenium_E2E_Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo_Practice2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.com/demo");

		driver.findElement(By.xpath("//strong[text()='Login']")).click();
		System.out.println(driver.getWindowHandle());

		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		String parent = it.next();
		String child = it.next();

		driver.switchTo().window(child);

		driver.findElement(By.cssSelector("[type='email']")).sendKeys("Hello@gmail.com");
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("hello@123");

		driver.findElement(By.xpath("//a[text()='Forgot Password']")).click();

		driver.navigate().back();

		driver.findElement(By.cssSelector("[type='password']")).sendKeys("hello@123");
		driver.findElement(By.cssSelector("[id='submit']")).click();

		driver.switchTo().window(parent);

		driver.findElement(By.cssSelector("strong[class='mx-2']")).click();

		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Set<String> windows = driver.getWindowHandles();

		ArrayList<String> tabs = new ArrayList<String>(windows);

		// Important note - window handles will store in the way how the tabs are opened
		// in the order, 1st tab opened was main page(0), 2nd was login tab(1), 3rd was
		// calendar(2)
		driver.switchTo().window(tabs.get(2));

		WebDriverWait expWait = new WebDriverWait(driver, 5);
		expWait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[id='onetrust-accept-btn-handler']")))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("[data-id='event-type']")).click();

		expWait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[aria-label='Go to next month']")))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("[aria-label='Wednesday, January 8 - Times available']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-component='spot-list']/div[3]")).click();

		driver.findElement(By.xpath("//a[text()='Report abuse']")).click();

		Set<String> window2 = driver.getWindowHandles();

		ArrayList<String> tabs2 = new ArrayList<String>(window2);

		driver.switchTo().window(tabs2.get(3));
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"/html//div[@id='root']/div/div/div[@class='EycK1VQJ8ECvekVTx_Ch aSdf7y61Ba018W2l__c7']/div[@class='IobRbTiKNaRXK_YOvire aXh6hwxacNnPdKNF58LR']/form/span/div[1]/div/div[1]/div[2]/fieldset/div[5]/label[@class='Fzznp6ONV1t_7QYjM6o3 k7Ck_R0D_V7mHRoikaEh']/div"))
				.click();

		driver.findElement(By.cssSelector("textarea[maxlength='255']")).sendKeys("Just a demo");

		driver.getPageSource().contains("Submission successful");
		Thread.sleep(2000);

		for (int i = 1; i <= tabs.size(); i++) {
			driver.switchTo().window(tabs2.get(i));
			Thread.sleep(2000);
			driver.close();

		}

		driver.quit();
	}

}
