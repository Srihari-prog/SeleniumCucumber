import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class Practice_11 {

	public static void main(String[] args) throws IOException {

		// Taking screenshot

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Resorces\\edgedriver_win64\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		takingScreenShot(driver);
		driver.close();

	}

	public static void takingScreenShot(WebDriver webdriver) throws IOException {

		File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\janan\\OneDrive\\Desktop\\Eclipse\\Screenshots\\sample.png" + timeStamp());
		FileUtils.copyFile(srcFile, destFile);
	}
	
	// amending the screenshot with current date and time
	
	public static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
