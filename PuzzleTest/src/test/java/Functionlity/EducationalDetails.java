package Functionlity;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BasePOI.EducationPOI;
import BasePOI.LoginPOI;
import BasePOI.ProfilePOI;
import BasePOI.Setup;

public class EducationalDetails {
	
	public WebDriver driver;

	Setup Browsersetup = new Setup(driver);
	LoginPOI obj_Log = new LoginPOI();
	ProfilePOI obj_prof = new ProfilePOI();
	EducationPOI obj_edu=new EducationPOI();
	
	
	
	
	
	@Test(priority = 0)
	public void openprofile() {

		//Browsersetup.Websiteopen();

		obj_Log.waitforLoader();

		obj_Log.click_Login_button();

		obj_Log.waitforLoader();

	}
	
	@Test(priority = 1)
	public void CounselorLogincase1() {

		obj_Log.click_Login_counselor();

		obj_Log.waitforLoader();

		try {
			obj_Log.Enter_login_data("camel@gmail.com", "123456");

			obj_Log.click_Login();

			obj_Log.waitforProfileopen();

		} catch (NoSuchElementException e) {
		}

		if (obj_prof.verifyprofileopen1() == true) {

			System.out.println("TC07-->Username or  password correct, so User should  be Logged in-->Pass");
		} else {

			System.out.println("TC07-->Username or  password correct, so User should  be Logged in-->Fail");
		}

		obj_prof.waitforprofileloading();
		
		obj_edu.click_drawer_Education_button();
	}
	
	
	
	@Test(priority =2 )
	public void AddNewEducation() throws InterruptedException  {
			
		obj_edu.waitforEducationloading();
		
		obj_edu.AddNewEdu_button();
		Thread.sleep(10000);
		
		if(obj_edu.verifyAddnewEducationpageopen()==true){
			
			System.out.println("TC08-->Add Education page open  successfully-->Pass");
		}else{
			
			System.out.println("TC08-->Add Education page open  successfully-->Fail");
		}
		
		
		
		obj_edu.AddEducationDetails("Engineer", "Harshal");
		
		if(obj_edu.verifyaddedEducation()==true){
			
			System.out.println("TC09-->Education added successfully-->Pass");
		}else{
			
			System.out.println("TC09-->Education added successfully-->Fail");
		}
		
		obj_edu.waitforEducationloading();
	}
	
	@Test(priority =3 )
	public void BackbuttonAddNewEducation() throws InterruptedException{
		
		
		obj_edu.AddNewEdu_button();
		Thread.sleep(10000);
		
		obj_edu.bac_click();
		
		obj_edu.waitforEducationloading();
		
		if(obj_edu.Educationdetails()==true){
			
			System.out.println("TC10-->Back button on AddEducation page Working-->Pass");
			
		}else{
			
			System.out.println("TC10-->Back button on AddEducation page Working-->Fail");
		}
		
		obj_Log.click_Logout();
	}
	
	
	
}
	
	
