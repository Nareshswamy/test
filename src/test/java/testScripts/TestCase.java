package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BlogPage;
import pageObjects.HomePage;
import pageObjects.IntegrationsPage;

public class TestCase {
	
	public static RemoteWebDriver driver;
	static String ActualUrl = "";
	static String ExpectedUrl ="";
	static String platForm ="";
	

    @BeforeTest
    @Parameters({"Platform","BrowserName","Version"})
    public RemoteWebDriver setup(String platform,String browserName,String version) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "nareshswamy007" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "eUXAqxrWfUpXH5U8WGTc2NCV0wnkp7RFz4LP3cEz9SXgjqtKee" : System.getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", platform);
        caps.setCapability("browserName", browserName);
        caps.setCapability("version", version);
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "LambdaTestAssignment");
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);
        platForm =platform;

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        return driver;
    }
    
    @Test
    @Parameters({"Platform","BrowserName","Version"})
    public void testCase(String platform,String browserName,String version) throws InterruptedException {
    	driver.get("https://www.lambdatest.com/");    	
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("window.scrollBy(0,4000)");
		
		if(platForm.equalsIgnoreCase("Windows 10")) {
			HomePage.SeeAllIntegrations(driver).sendKeys(Keys.CONTROL,Keys.ENTER); 
		}
		else {
			HomePage.SeeAllIntegrations(driver).sendKeys(Keys.COMMAND,Keys.ENTER);
		}
		
		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles()); 
		for(int i=0;i<=windows.size();i++) {
			System.out.println(windows.get(0).toString());
		}
		
		System.out.println("Before Switching:-"+driver.getTitle());
		driver.switchTo().window(windows.get(1));
		Thread.sleep(3000);
		System.out.println("After Switching:-"+driver.getTitle());
		
		ActualUrl = driver.getCurrentUrl();
		ExpectedUrl = "https://www.lambdatest.com/integrations";
		Assert.assertEquals(ActualUrl, ExpectedUrl,"Both Urls Are Same");
		Js.executeScript("window.scrollBy(0,300)");
		
		WebElement CodelessAutomation = IntegrationsPage.CodelessAutomation(driver);
		Js.executeScript("arguments[0].scrollIntoView(true);",CodelessAutomation);
		Thread.sleep(5000);
		Js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		IntegrationsPage.LearnMore(driver).click();
		String ActualTitle = driver.getTitle().toString();
		String ExpectedTitle = "‘TestingWhiz Integration | LambdaTest";
		
		try {
			Assert.assertEquals(ActualTitle, ExpectedTitle,"Both titles Are Same");
		} catch (AssertionError e) {
				System.out.println("Titles are Not same");
		}
		
		driver.close();
		driver.switchTo().window(windows.get(0));
		System.out.println(windows.size());
		driver.get("https://www.lambdatest.com/blog");
		Js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		BlogPage.ClosePopup(driver);
		BlogPage.Community(driver).click();
		driver.getCurrentUrl();
		ActualUrl = driver.getCurrentUrl();
		ExpectedUrl = "https://community.lambdatest.com/";
		Assert.assertEquals(ActualUrl, ExpectedUrl,"Both Urls Are Same");
		driver.close();

		
    }
    
    


}
