package BasePOI;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {

    public  static WebDriver driver;
    By counselor=By.id("counselor_login");
    public  void Websiteopen() 
    {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://192.163.222.186/~puzzlelife/development/");
    }

    public Setup(WebDriver driver)
    {

        this.driver=driver;
    }
    public Setup()
    {
    }
    public WebDriver getDriver()
    {
        return this.driver;
    }

    
    
    public void closebrowser(){
		
		
		driver.close();
	}
}