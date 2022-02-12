package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private static WebElement el =null;
	
	 public static WebElement SeeAllIntegrations(WebDriver driver)
	 {
		 el =  driver.findElement(By.xpath("//div[@class='clearfix']/div/div/a"));;
		 return el;
	 }
	 


}
