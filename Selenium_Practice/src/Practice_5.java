import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Practice_5 {

	public static void main(String[] args) throws InterruptedException {

		// handling windows

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");

		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);

		driver.findElement(By.id("tabButton")).click();

		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);

		Iterator<String> it = windows.iterator();

		for (String iter : windows) {
			if (!mainWindow.equals(windows)) {
				driver.switchTo().window(iter);
				Thread.sleep(2000);
			}
		}
		driver.close();

		Thread.sleep(2000);
		driver.quit();
	}

}
