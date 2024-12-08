package AllConceptsPractice;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllConcepts {

	public static void main(String[] args) throws InterruptedException {
		
		// All concepts
		
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		// Text field
		driver.get("https://demoapps.qspiders.com/ui");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#name")).sendKeys("Srihari");
		driver.findElement(By.id("email")).sendKeys("Srihari@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Srihari123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
		
		// buttons
		driver.findElement(By.xpath("//section[text()='Button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.findElement(By.xpath("//button[text()='No']")).click();
		driver.findElement(By.id("btn7")).click();
		Thread.sleep(2000);
		
		// drop down
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		Thread.sleep(2000);
		
		Select dropDown = new Select(driver.findElement(By.id("select2")));
		dropDown.selectByVisibleText("Male");
		
		// Window handling
		driver.get("https://demoapps.qspiders.com/ui/browser");
		Thread.sleep(2000);
		driver.findElement(By.id("browserLink1")).click();
		driver.findElement(By.xpath("//a[text()='New Tab']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("browserButton4")).click();
		
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> handles = new ArrayList<String>(windows);
		System.out.println(handles);
		driver.switchTo().window(handles.get(1));
		driver.findElement(By.id("email")).sendKeys("sri@gmail.com");
		driver.switchTo().window(handles.get(2));
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
		
		driver.quit();

	}

}
