package BasePOI;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOI {
	public WebDriver driver;

	// home
	By home_login = By.linkText("Login");
	By about_us = By.linkText("About Us");

	// login
	By counselor = By.id("counselor_login");
	By user = By.id("user_login");
	By username = By.id("username");
	By password = By.id("password");
	By Login = By.xpath("//button[@type='submit']");
	By create_account = By.name("Login");

	By Logout = By.linkText("Logout");
	By Loader=By.id("loader");

	public void click_Login_button() {

		this.driver = new Setup().getDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(home_login).click();

	}

	public void click_Login_counselor() {
		
		driver.findElement(counselor).click();
	}

	public void click_Login_user() {
		driver.findElement(user).click();
	}

	public void Enter_login_data(String uname, String pwd) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
	}

	public void click_Login() {
		driver.findElement(Login).click();
	}
	
	public void click_Logout() {
		driver.findElement(Logout).click();
	}
	
	public void waitforLoader(){
		
		this.driver = new Setup().getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Loader));
		
		
		
	}
	
	public void waitforloginopen(){
		
		FluentWait<WebDriver> w=new FluentWait<WebDriver>(driver);
		w.withTimeout(15, TimeUnit.SECONDS);
		w.pollingEvery(3, TimeUnit.SECONDS);
		w.until(ExpectedConditions.presenceOfElementLocated(Login));
		
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(Loader));
		//wait.until(ExpectedConditions.presenceOfElementLocated(Login));
		
		
	}
	
	
	public void waitforProfileopen(){
		
		this.driver = new Setup().getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Loader));
		wait.until(ExpectedConditions.presenceOfElementLocated(Logout));
		
		
	}
	
	public boolean Verify_Login(){
		
		boolean str=driver.findElement(Login).isDisplayed();
		
		return str;
		
}
	
	public boolean Verify_Login1(){
		
		boolean str=driver.findElement(Logout).isDisplayed();
		
		//System.out.println(str);
		
		return str;
		
}
	
	public void capturescreenshot(){
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("D:/puzzle/img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
