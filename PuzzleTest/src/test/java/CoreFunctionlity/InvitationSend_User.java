package CoreFunctionlity;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BasePOI.ExperiencePOI;
import BasePOI.InvitationPOI;
import BasePOI.LoginPOI;
import BasePOI.ProfilePOI;
import BasePOI.Setup;

public class InvitationSend_User {
	
	public WebDriver driver;

	Setup Browsersetup = new Setup(driver);
	LoginPOI obj_Log = new LoginPOI();
	ProfilePOI obj_prof = new ProfilePOI();
	ExperiencePOI obj_exp=new ExperiencePOI();
	InvitationPOI obj_inv=new InvitationPOI();
	
	
	@Test(priority = 0)
	public void openprofile() throws InterruptedException {

		Browsersetup.Websiteopen();

		obj_Log.waitforLoader();

		obj_Log.click_Login_button();

		obj_Log.waitforLoader();
		Thread.sleep(5000);

	}
	
	@Test(priority = 1)
	public void CounselorLogincase1() {

		obj_Log.click_Login_user();

		obj_Log.waitforLoader();

		try {
			obj_Log.Enter_login_data("auto@gmail.com", "123456");

			obj_Log.click_Login();

			obj_Log.waitforProfileopen();

		} catch (NoSuchElementException e) {
		}

		if (obj_prof.verifyprofileopen2() == true) {

			System.out.println("TC07-->Username or  password correct, so User should  be Logged in-->Pass");
		} else {

			System.out.println("TC07-->Username or  password correct, so User should  be Logged in-->Fail");
		}

		obj_prof.waitforprofileloading();
		
		//obj_inv.click_vavigation_Invi();
		
		
		
	}

	@Test(priority=2)
	public void openViewcounselor() throws InterruptedException{
		
		obj_inv.HomeimgVisibility();
		
		obj_inv.wait_forHomepage();
		
		obj_inv.click_homesearch();
		
		obj_inv.wait_counsearchpage();
		
		if (obj_inv.Verify_counseloropen1() == true) {

			System.out.println("TC14-->Counselor search page successfully open-->Pass");
		} else {

			System.out.println("TC14-->Counselor search page successfully open-->Fail");
		}
		
		Thread.sleep(5000);
		
		obj_inv.Enter_search_Text("Harshaldd Bagul");
		
		obj_inv.click_counselorsearch();
		
		if (obj_inv.Verify_counseloropen2() == true) {

			System.out.println("TC15-->Counselor search result display successfully-->Pass");
		} else {

			System.out.println("TC15-->Counselor search result display successfully-->Fail");
		}
		
		obj_inv.clickoncounselor();
		
		if (obj_inv.verify_opencounselor() == true) {

			System.out.println("TC16-->View Counselor open successfully-->Pass");
		} else {

			System.out.println("TC16-->View Counselor open successfully-->Fail");
		}
		
		
		
	}
	
	@Test(priority=3)
	public void send_Invitation() throws InterruptedException{
		obj_prof.scrollup();
		Thread.sleep(5000);
		obj_inv.open_sendinvitation();
		
		
		
	}
}
