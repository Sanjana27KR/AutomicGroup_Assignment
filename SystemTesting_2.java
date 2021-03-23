package automic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SystemTesting_2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\browserdrivers\\Chrome_Driver\\chromedriver_89.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://abr.business.gov.au/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id=\"SearchText\"]")).sendKeys("Automic");
		driver.findElement(By.cssSelector("input[id=\"MainSearchButton\"]")).click();
		
		//Click on the link
		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/a[1]")).click();
		
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'AUTOMIC PTY LTD')]")).getText());
		System.out.println(driver.findElement(By.xpath("//td[contains(text(),'Active from 19 Jun 2012')]")).getText());
		
		String entityName = driver.findElement(By.xpath("//span[contains(text(),'AUTOMIC PTY LTD')]")).getText();
		
		//Checking for the expected result
		if(entityName.equalsIgnoreCase("AUTOMIC PTY LTD")) {
			System.out.println("Test case pass");
		}
		else {
			System.out.println("Test case fail");
		}
	}

}
