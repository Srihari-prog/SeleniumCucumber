import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice_6 {

	public static void main(String[] args) throws InterruptedException {

		// Mouse actions - drag&drop, right click

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/dragdrop/");

		WebElement dest = driver.findElement(By.id("bin"));

		List<WebElement> sources = driver.findElements(By.xpath("//li/a"));
		System.out.println(sources);
		Actions action = new Actions(driver);
		for (WebElement i : sources) {
			action.dragAndDrop(i, dest).build().perform();
			Thread.sleep(1000);
		}

		Thread.sleep(2000);

		// context click - Right click

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));

		List<WebElement> clicks = driver
				.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li"));
		System.out.println(clicks);
		for (WebElement j : clicks) {
			action.contextClick(rightClickBtn).click(j).build().perform();
			driver.switchTo().alert().accept();
			if (j.getText().contains("Del"))
				break;

		}

		driver.close();

	}

}
