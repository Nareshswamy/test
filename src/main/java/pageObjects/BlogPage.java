package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {
	private static WebElement el =null;
	private static List<WebElement>elements = null;
	
	
	public static void ClosePopup(WebDriver driver)
	 {
		 elements =  driver.findElements(By.xpath("//div[@id='normal-slidedown']/div[2]/button[2]"));
		 if(elements.size()>0) {
			 driver.findElement(By.xpath("//div[@id='normal-slidedown']/div[2]/button[2]")).click();
		 }
		 
	 }
	
	 public static WebElement Community(WebDriver driver)
	 {
		 el =  driver.findElement(By.xpath("//div[@id='navbar']/nav/div/ul/li[5]"));;
		 return el;
	 }
	 

}
