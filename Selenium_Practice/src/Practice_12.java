import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice_12 {

	public static void main(String[] args) throws InterruptedException {

		// Handling multiple windows and tabs

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Windows.html");

		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);

		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();
		driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[text()='Open Seperate Multiple Windows']")).click();
		driver.findElement(By.cssSelector("[onclick='multiwindow\\(\\)']")).click();

		Set<String> childWindows = driver.getWindowHandles();
		ArrayList<String> windows = new ArrayList<String>(childWindows);

		System.out.println(windows);
		System.out.println(windows.size());

		driver.switchTo().window(windows.get(1));

		driver.findElement(By.id("navbarDropdown")).click();
		driver.findElement(By.xpath("//a[text()='About Selenium']")).click();

		driver.switchTo().window(windows.get(2));
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.switchTo().window(windows.get(3));
		Thread.sleep(2000);

		driver.switchTo().window(mainWindow);
		Thread.sleep(2000);

		driver.quit();

	}

}
