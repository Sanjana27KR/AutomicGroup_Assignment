package automic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\browserdrivers\\Chrome_Driver\\chromedriver_89.exe");
		//Open the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Navigate to the URL
		driver.get("https://abr.business.gov.au/");
		driver.manage().window().maximize();
		
		//Type Automic in the lookup field
		driver.findElement(By.cssSelector("input[id=\"SearchText\"]")).sendKeys("Automic");
		driver.findElement(By.cssSelector("input[id=\"MainSearchButton\"]")).click();
		
		System.out.println(driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText());
		
		String text = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		
		//Checking for the expected result
		if(text.equalsIgnoreCase("AUTOMIC PTY LTD")) {
			System.out.println("Test Case pass");
		}
		else {
			System.out.println("Test Case fail");
		}
	}

}
