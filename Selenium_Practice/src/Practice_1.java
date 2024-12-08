import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice_1 {

	public static void main(String[] args) throws InterruptedException {


		//Select drop-down and complete the checkout
		
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
		
		WebElement dropDown = driver.findElement(By.cssSelector("select[class=product_sort_container]"));
		Select option = new Select(dropDown);
		
		option.selectByValue("lohi");
		
		WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
		addToCartBtn.click();
		
		driver.findElement(By.cssSelector("a[class=shopping_cart_link]")).click();
		
		WebElement checkOutBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
		checkOutBtn.click();
		
		driver.findElement(By.id("first-name")).sendKeys("Sri");
		driver.findElement(By.id("last-name")).sendKeys("Prahal");
		driver.findElement(By.id("postal-code")).sendKeys("635109");
		driver.findElement(By.cssSelector("#continue")).click();
		
		String total = driver.findElement(By.cssSelector("div[class=summary_total_label]")).getText();
		System.out.println(total);
	}

}
