package BasePOI;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePOI {
	
	public WebDriver driver;
	

		By Logout = By.linkText("Logout");
		By Loader=By.id("loader");
		
		
		//personal details
		By fname=By.id("fname");
		By lname=By.id("lname");
		By contat=By.id("contact_number");
		By gender=By.id("gender");
		By country=By.id("countryid");
		By state=By.id("stateid");
		By city=By.id("cityid");
		By street=By.id("street");
		By add=By.id("address");
		By Totalexp=By.id("experience_years");
		By Rate=By.id("rate_per_hour");
		By comm=By.id("commision_percentage");
		By update=By.id("btn_update");
		By name1=By.xpath("html/body/div[1]/div[2]/div/div/div/div[1]/div/div[2]/div/h1/span[1]");
		By name2=By.xpath("html/body/div[1]/div[2]/div/div/div/div[1]/div/div[2]/div/h1/span[2]");
		By browse=By.id("profile_pic");
		By profileimage=By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div/div[1]/div/img");
		By updatesuccessmsg=By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div/div[2]/ng-include/div/div[2]/div[3]");
		
		//navigation drawer
		By personaldetails_click=By.linkText("Personal Details");
		By Educationdetails_click=By.linkText("Education");
		By Experiancedetails_click=By.linkText("Experience");
		By Invitationdetails_click=By.linkText("Invitations");
		By Categorydetails_click=By.linkText("Category");
		
		
		public boolean verifyprofileopen1(){
			
			this.driver = new Setup().getDriver();
			String url="http://192.163.222.186/~puzzlelife/development/#/profile"; 
			//System.out.println("vfyprofile"+driver.getCurrentUrl());
			boolean vfyprofile=url.equals(driver.getCurrentUrl());
			//System.out.println(vfyprofile);
			return vfyprofile;
		}
		
		public boolean verifyprofileopen2(){
			
			this.driver = new Setup().getDriver();
			String url="http://192.163.222.186/~puzzlelife/development/#/userprofile"; 
			//System.out.println("vfyprofile"+driver.getCurrentUrl());
			boolean vfyprofile=url.equals(driver.getCurrentUrl());
			//System.out.println(vfyprofile);
			return vfyprofile;
		}
		
		public void waitforprofileloading(){
			
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.elementToBeClickable(fname));
			
			
			
		}
		
		

		public void update_personal_Details(String name,String laname,String caontat,String aadd,String Totaalexp,String Raate,String coamm){
			try{
				//this.driver = new Setup().getDriver();
		
			driver.findElement(fname).clear();
			driver.findElement(fname).sendKeys(name);
			
			
			driver.findElement(lname).clear();
			driver.findElement(lname).sendKeys(laname);
			
			driver.findElement(contat).clear();
			driver.findElement(contat).sendKeys(caontat);
			
			driver.findElement(add).clear();
			driver.findElement(add).sendKeys(aadd);
			
			driver.findElement(Totalexp).clear();
			driver.findElement(Totalexp).sendKeys(Totaalexp);
			
			driver.findElement(Rate).clear();
			driver.findElement(Rate).sendKeys(Raate);
			
			driver.findElement(comm).clear();
			driver.findElement(comm).sendKeys(coamm);
				
			}catch(NoSuchElementException e){}
		}
		
		
		public void selectGender(){
			
			WebElement dp=driver.findElement(gender);
			Select dropdown=new Select(dp);
			dropdown.selectByIndex(2);
			
		}
		
		public void selectCountry(){
			
			WebElement dp=driver.findElement(country);
			Select dropdown=new Select(dp);
			dropdown.selectByVisibleText("India");
			
		}
		
		public void selectState(){
			
			WebElement dp=driver.findElement(state);
			Select dropdown=new Select(dp);
			dropdown.selectByVisibleText("Maharashtra.");
			
		}
		
		public void selectCity(){
			
			WebElement dp=driver.findElement(city);
			Select dropdown=new Select(dp);
			dropdown.selectByVisibleText("Nashik");
			
		}
		
		public void updateinfo(){
			
			driver.findElement(update).click();
		}
		
		public boolean updatevalidation(){
			
			String a="Your personal details updated successfully";
			String b=driver.findElement(updatesuccessmsg).getText();
			boolean abc=b.equals(a);
			return true;
			
		}
		
		public void waitforupdatevalidation(){
			
			WebDriverWait wait = new WebDriverWait(driver, 7);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(updatesuccessmsg));
			
		}
		
		
		
		public void scrollup(){
			
			WebElement element = driver.findElement(Logout);
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
		}
		
		public void scrolldown(){
			
			WebElement element = driver.findElement(Logout);
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
		}
		
		public void browseimage() throws IOException{
			
			driver.findElement(browse).click();
			
			Runtime.getRuntime().exec("D:\\New PC\\autoit\\profileimage.exe");
			
			
			
			
		}
		
		public boolean verifyimage(){
			String imagepath="http://192.163.222.186/~puzzlelife/development/assets/counseler/profile_pic/profile_pic_58807bc832054.jpg";                  
			String img=driver.findElement(profileimage).getAttribute("src");
			boolean abc=imagepath.equals(img);
			return true;
		}
		
		public void simpledatepicker(){
			
			
			
		 
		  
		  //Click on textbox so that datepicker will come  
		  driver.findElement(By.id("datepicker")).click();  
		  
		  driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();  
		    
		  /*DatePicker is a table.So navigate to each cell   
		   * If a particular cell matches value 13 then select it  
		   */  
		  
		  WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));  
		  List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));  
		  List<WebElement> columns=dateWidget.findElements(By.tagName("td"));  
		    
		  for (WebElement cell: columns){  
		   //Select 13th Date   
		   if (cell.getText().equals("13")){  
		   cell.findElement(By.linkText("13")).click();  
		   break;  
		   }  
		  }   
	}	   
}
