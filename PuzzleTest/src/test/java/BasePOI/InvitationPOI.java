package BasePOI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvitationPOI {
	
	
public WebDriver driver;
	
	//navigation drawer
	By personaldetails_click=By.linkText("Personal Details");
	By Educationdetails_click=By.linkText("Education");
	By Experiancedetails_click=By.linkText("Experience");
	By Invitationdetails_click=By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div[1]/nav/ul/li[2]/a");
	By Categorydetails_click=By.linkText("Category");
	
	//userinvitation
	By puzzleimg=By.xpath("//img[@alt='Puzzle Of My Life']");
	By Homesearch=By.xpath("//button[@type='submit']");
	
	//counselorpage
	By Counselor_serach=By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div/div/div/form/div[2]/button");
	By searchby_name=By.id("counselor_name");
	By searchby_location=By.id("location_name");
	By viewprofile=By.linkText("View Profile");
	By fname=By.name("Tushar9");
	
	
	//viewcounselor
	By sendinvitation_navigtion=By.linkText("Send Invitation");
	By firstname=By.id("fname");
	
	//sendinvitation
	By submit = By.xpath("//button[@type='button']");
	By title=By.id("title");
	By description=By.id("desc");
	
	
	public void click_drawer_Experience_button() {

		this.driver = new Setup().getDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(Invitationdetails_click).click();

	}
	
	
	public void wait_forHomepage(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(Homesearch));
	}
	
	
	public void wait_counsearchpage(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(Homesearch));
	}
	
	public void click_vavigation_Invi(){
		this.driver = new Setup().getDriver();
		driver.findElement(Invitationdetails_click).click();
		
	}
	
	public void HomeimgVisibility(){
		this.driver = new Setup().getDriver();
		boolean b=driver.findElement(puzzleimg).isDisplayed();
		if(b==true){
			
			driver.findElement(puzzleimg).click();
		}
		
	}

	public void click_homesearch(){
		
		driver.findElement(Homesearch).click();
		
	}
	
	public void click_counselorsearch(){
		
		Actions action = new Actions(driver);
		WebElement element=driver.findElement(Counselor_serach);

		//Double click
		action.doubleClick(element).perform();
	
		
	}
	
	public void Enter_search_Text(String name){
		
		driver.findElement(searchby_name).clear();
		driver.findElement(searchby_name).sendKeys(name);
		
	}
	
	public boolean Verify_counseloropen1(){
		
		boolean location=driver.findElement(searchby_name).isDisplayed();
		System.out.print(location);
		return location;
	}
	
	public boolean Verify_counseloropen2(){
		String v=driver.findElement(viewprofile).getText();
		boolean view=driver.findElement(viewprofile).isDisplayed();
		System.out.print(view+"  cfghh " +v);
		return view;
	}
	
	public void clickoncounselor(){
		
		driver.findElement(viewprofile).click();
	}
	
	public void wait_fr_viewcounser(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(firstname));
	}
	
	public boolean verify_opencounselor(){
		wait_fr_viewcounser();
		boolean sendinvitation=driver.findElement(sendinvitation_navigtion).isDisplayed();
		System.out.print(sendinvitation);
		return sendinvitation;
	}
	
	
	public void wait_fr_sendinvitation(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(submit));
	}
	
	
	public boolean verify_opencounseloreducation(){
		
		boolean sendinvitation=driver.findElement(sendinvitation_navigtion).isDisplayed();
		System.out.print(sendinvitation);
		return sendinvitation;
	}
	
	public void open_sendinvitation(){
		
		driver.findElement(sendinvitation_navigtion).click();
		
	}
	
	public void Add_invitation(String invitation_name,String desc){
		
		driver.findElement(title).sendKeys(invitation_name);
		driver.findElement(description).sendKeys(desc);
		
		
	}
}
