package Functionlity;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BasePOI.ExperiencePOI;
import BasePOI.LoginPOI;
import BasePOI.ProfilePOI;
import BasePOI.Setup;

public class Experience {

	public WebDriver driver;

	Setup Browsersetup = new Setup(driver);
	LoginPOI obj_Log = new LoginPOI();
	ProfilePOI obj_prof = new ProfilePOI();
	ExperiencePOI obj_exp=new ExperiencePOI();
	
	
	
	
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
		
		obj_exp.click_drawer_Experience_button();
	}
	
	
	
	@Test(priority=2)
	public void page_open_Experience_AddExperience() throws InterruptedException{
		
		Thread.sleep(10000);
		if(obj_exp.verifyexp_open()==true){
			
			System.out.println("TC08-->Experience details page open successfully-->Pass");
		}else{
			
			System.out.println("TC08-->Experience details page open successfully-->Fail");
		}
		
		obj_exp.click_Add_exp();
		
		obj_exp.Wait_AddExpe_details();
		
		
		if(obj_exp.verifyAddexppageopen()==true){
			
			System.out.println("TC09-->Add experience page open successfully-->Pass");
		}else{
			
			System.out.println("TC09-->Add experience page open successfully-->Fail");
		}
	}
	
	@Test(priority=3)
	public void backbutton() throws InterruptedException{
		
		
		obj_exp.click_back_exp();
		
		Thread.sleep(10000);
		
		if(obj_exp.verifyexp_open()){
			
			System.out.println("TC10-->On back from Add experience page Exp details open successfully-->Pass");
		}else{
			
			System.out.println("TC10-->On back from Add experience page Exp details open successfully-->Pass");
			
		}
		
	}
	
	
	@Test(priority=4)
	public void AddExperience() throws InterruptedException{
		
		obj_exp.click_Add_exp1();
		
		obj_exp.Wait_AddExpe_details();
		
		
		obj_exp.addexperiencedetails("ocs", "7","XYZ");
		
		Thread.sleep(3000);		
		
		
		if(obj_exp.verifyEcpadd()==true){
			
			System.out.println("TC11-->Experience added  successfully-->Pass");
		}else{
			
			System.out.println("TC11-->Experience added  successfully-->Fail");
			
		}
		
		obj_Log.click_Logout();
	}
	
}
