package BasePOI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExperiencePOI {

	
public WebDriver driver;
	
	//navigation drawer
	By personaldetails_click=By.linkText("Personal Details");
	By Educationdetails_click=By.linkText("Education");
	By Experiancedetails_click=By.linkText("Experience");
	By Invitationdetails_click=By.linkText("Invitations");
	By Categorydetails_click=By.linkText("Category");
	
	//experience
	By Addexpbutton=By.cssSelector(".edit_ifo");
	By backaddexp=By.cssSelector(".edit_ifo");
	By company=By.id("title");
	By ExpMonth=By.id("org_experience");
	By desc=By.id("description");
	By add=By.cssSelector(".df_button");
	By successmsg=By.cssSelector(".alert.alert-success.ng-binding");

	
	public void click_drawer_Experience_button() {

		this.driver = new Setup().getDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(Experiancedetails_click).click();

	}
	
	
	public void click_Add_exp(){
		
		driver.findElement(Addexpbutton).click();
		
	}
	
	public void click_Add_exp1(){
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(Addexpbutton)).click().build();
		
	}
	
	
	public void click_back_exp(){
		
		driver.findElement(backaddexp).click();
		
	}
	
	public void click_Add_exp_button(){
		
		driver.findElement(add).click();
		
	}
	
	
	public boolean verifyexp_open(){
		
		boolean addbtn=driver.findElement(Addexpbutton).isDisplayed();
		System.out.println(addbtn);
		return addbtn;
	}
	
	public boolean verifyAddexppageopen(){
		
		boolean backbtn=driver.findElement(backaddexp).isDisplayed();
		System.out.println(backbtn);
		return backbtn;
		
	}
	
	public void Wait_Expe_details(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(Addexpbutton));
		
	}
	
	public void Wait_AddExpe_details(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(backaddexp));
		
	}
	
	
	public void addexperiencedetails(String compname,String exp,String description){
		
		driver.findElement(company).clear();
		driver.findElement(company).sendKeys(compname);
		
		driver.findElement(ExpMonth).clear();
		driver.findElement(ExpMonth).sendKeys(exp);
		
		driver.findElement(desc).clear();
		driver.findElement(desc).sendKeys(description);
		
		click_Add_exp_button();
		
	}
	
	public boolean verifyEcpadd(){
		
		String a="Your experience details added successfully";
		String b=driver.findElement(successmsg).getText();
		System.out.println(b);
		boolean msg=b.equals(a);
		return msg;
		
		
		
	}
}
