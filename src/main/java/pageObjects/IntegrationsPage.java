package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntegrationsPage {
	private static WebElement el =null;
	

	 public static WebElement CodelessAutomation(WebDriver driver)
	 {
		 el =  driver.findElement(By.xpath("//h2[text()='Codeless Automation']"));
		 return el;
	 }
	 
	 public static WebElement LearnMore(WebDriver driver)
	 {
		 el = driver.findElement(By.xpath("//div[@id='codeless_row']/div/div[4]/a"));
		 //el =  driver.findElement(By.cssSelector("a[href='https://www.lambdatest.com/support/docs/testingwhiz-integration/']"));
		 return el;
	 }

}
