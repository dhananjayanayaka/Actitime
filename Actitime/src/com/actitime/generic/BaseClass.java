package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.actitime.pom.EnterTimeTrack;
import com.actitime.pom.Login;

public class BaseClass {
static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		Reporter.log("Open Browser",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@AfterTest
	public void closeBrowser() {
		Reporter.log("Close Browser",true);
		driver.quit();
	}
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("Login",true);
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);
		Login l=new Login(driver);
		l.setLogin(un, pw);
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("Logout",true);
		EnterTimeTrack e=new EnterTimeTrack(driver);
		Thread.sleep(2000);
		e.setLogout();
	}
}
