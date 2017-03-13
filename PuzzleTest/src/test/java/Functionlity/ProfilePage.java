package Functionlity;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePOI.LoginPOI;
import BasePOI.ProfilePOI;
import BasePOI.Setup;

public class ProfilePage {

	public WebDriver driver;

	Setup Browsersetup = new Setup(driver);
	LoginPOI obj_Log = new LoginPOI();
	ProfilePOI obj_prof = new ProfilePOI();

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

	}

	@Test(priority = 2)
	public void updateprofile1() throws InterruptedException {

		obj_prof.waitforprofileloading();

		obj_prof.verifyimage();
		
		obj_prof.update_personal_Details("harshal", "bagul", "9420863236", "Near big bajar", "5", "9", "88");

		obj_prof.selectGender();

		obj_prof.selectCountry();

		obj_prof.selectState();

		obj_prof.selectCity();

		obj_prof.updateinfo();

		obj_prof.scrollup();

		Thread.sleep(3000);

		if(obj_prof.updatevalidation()==true){
			
			System.out.println("TC08-->Update profile info(Name,surname,contact,Address,Ranking,Rating,Comission-->Pass");
		}else{
			
			System.out.println("TC08-->Update profile info(Name,surname,contact,Address,Ranking,Rating,Comission-->Fail");
		}
		obj_prof.updatevalidation();
		
		obj_Log.click_Logout();

	}
}
