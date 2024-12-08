import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Practice_10 {

	public static void main(String[] args) {
		
		// Working with calendar
		
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		driver.findElement(By.id("#datepicker1")).click();
		
		String expDate = "01/07/2026";
		String dateTitle = driver.findElement(By.cssSelector("[class='ui-datepicker-title']")).getText();
		System.out.println(dateTitle);
		driver.close();

	}

}
