package BasePOI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EducationPOI {
	
	public WebDriver driver;
	
	//navigation drawer
	By personaldetails_click=By.linkText("Personal Details");
	By Educationdetails_click=By.linkText("Education");
	By Experiancedetails_click=By.linkText("Experience");
	By Invitationdetails_click=By.linkText("Invitations");
	By Categorydetails_click=By.linkText("Category");
	
	//education
	By addedu=By.cssSelector(".edit_ifo");
	By header=By.xpath("//*[@id='edu_view_div']/table/thead/tr/th[1]");
	By Title=By.id("title");
	By Authorityby=By.id("authority_by");
	By authoritydate=By.cssSelector(".input-group-addon");
	By todatdate=By.cssSelector(".day.today");
	By desc=By.id("description");
	By add_click=By.cssSelector(".df_button");
	By veifymsgedu=By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/ng-include/div/div[5]");
	By eduback=By.cssSelector(".edit_ifo");
			
			
	
	public void click_drawer_Education_button() {

		this.driver = new Setup().getDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(Educationdetails_click).click();

	}
	
	
	public void AddNewEdu_button(){
		
		driver.findElement(addedu).click();
		
	}
	
	public void bac_click(){
		
		driver.findElement(eduback).click();
		
	}
	
	public void waitforEducationloading(){
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement text=driver.findElement(header);
		
		wait.until(ExpectedConditions.textToBePresentInElement(text, "Title"));
		
			
	}
	
	public void waitforAddEducationloading(){
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(eduback));
		
			
	}
	
	public boolean verifyAddnewEducationpageopen(){
		
		boolean backbutton=driver.findElement(eduback).isDisplayed();
		//System.out.println(backbutton);
		return backbutton;
		
	}
	
	public void AddEducationDetails(String education,String name){
		
		driver.findElement(Title).clear();
		driver.findElement(Title).sendKeys(education);
		
		driver.findElement(authoritydate).click();
		
		driver.findElement(Authorityby).clear();
		driver.findElement(Authorityby).sendKeys(name);
		
		driver.findElement(add_click).click();
		
		
		
	}
	
	public boolean verifyaddedEducation(){
		
		String a="Your experience details added successfully";
		String b=driver.findElement(veifymsgedu).getText();
		boolean abc=b.equals(a);
		return true;
	}
	
	public boolean Educationdetails(){
		
		boolean addbutton=driver.findElement(addedu).isDisplayed();
		return addbutton;
	}

}

	
