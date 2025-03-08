package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LandingPage;

public class DriverBase {

	WebDriver driver;
	Properties prop;
	FileInputStream fs;
	public String browser;
	public String url;
	LandingPage landingPage;

	public WebDriver invokeDriver() throws IOException {

		prop = new Properties();
		fs = new FileInputStream(
				System.getProperty("user.dir") + "//SeleniumBDDFramework1//src//main//java//config//data.properties");
		prop.load(fs);

		browser = prop.getProperty("browser");
		url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("Switch to chrome driver");
		}
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = invokeDriver();
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=false)
	public void closeBrowser() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
