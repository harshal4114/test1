package Functionlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePOI.LoginPOI;
import BasePOI.Setup;

public class Login  
{
    public WebDriver driver;
    
    Setup Browsersetup = new Setup(driver);
	LoginPOI obj_Log = new LoginPOI();

	
    
	@Test
	public void openwebsite() throws InterruptedException {
		

		Browsersetup.Websiteopen();
		
		obj_Log.waitforLoader();

		obj_Log.click_Login_button();
		
		obj_Log.waitforloginopen();

		

	}
	
	@Test(priority=1)
	public void CounselorLogincase1(){
		
		obj_Log.click_Login_counselor();
		
		
		try{
			obj_Log.Enter_login_data("camefl@gmail.com", "123456");
		
			obj_Log.click_Login();
			
		}catch(NoSuchElementException e){}
			
			if(obj_Log.Verify_Login()==true){
				
				System.out.println("TC01-->Username or  password worng, so User should not be Logged in-->Pass");
			}else{
				
				System.out.println("TC01-->Username or  password worng, so User should not be Logged in-->Fail");
			}
		
		
	}
	
	@Test(priority=2)
	public void CounselorLogincase2(){
		
		
		try{
			obj_Log.Enter_login_data("camefl@gmail.com", "1234556");
		
			obj_Log.click_Login();
			
		}catch(NoSuchElementException e){}
			
			if(obj_Log.Verify_Login()==true){
				
				System.out.println("TC02-->Username or  password worng, so User should not be Logged in-->Pass");
			}else{
				
				System.out.println("TC02-->Username or  password worng, so User should not be Logged in-->Fail");
			}
		
		
	}
	
	@Test(priority=3)
	public void CounselorLogincase3(){
		
		
		try{
			obj_Log.Enter_login_data("camel@gmail.com", "123456");
		
			obj_Log.click_Login();
			
			obj_Log.waitforProfileopen();
			
		}catch(NoSuchElementException e){}
			
			if(obj_Log.Verify_Login1()==true){
				
				System.out.println("TC03-->Username or  password Valid, so User should  be Logged in-->Pass");
			}else{
				
				System.out.println("TC03-->Username or  password worng, so User should not be Logged in-->Fail");
			}
		
			obj_Log.click_Logout();
			obj_Log.waitforLoader();
	}
		
	
	@Test(priority=4)
	public void UserLogincase1(){
		
		obj_Log.click_Login_button();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {}
		
		obj_Log.click_Login_user();
		obj_Log.waitforLoader();
		
		
		try{
			obj_Log.Enter_login_data("harshbagful@gmail.com", "123456");
		
			obj_Log.click_Login();
			
		}catch(NoSuchElementException e){}
			
			if(obj_Log.Verify_Login()==true){
				
				System.out.println("TC04-->Username or  password worng, so User should not be Logged in-->Pass");
			}else{
				
				System.out.println("TC04-->Username or  password worng, so User should not be Logged in-->Fail");
			}
		
		
	}
	
	@Test(priority=5)
	public void UserLogincase2(){
		
		
		try{
			obj_Log.Enter_login_data("harshbaegul@gmail.com", "1234556");
		
			obj_Log.click_Login();
			
		}catch(NoSuchElementException e){}
			
			if(obj_Log.Verify_Login()==true){
				
				System.out.println("TC05-->Username or  password worng, so User should not be Logged in-->Pass");
			}else{
				
				System.out.println("TC05-->Username or  password worng, so User should not be Logged in-->Fail");
			}
		
		
	}
	
	@Test(priority=6)
	public void UserLogincase3() throws InterruptedException{
		
		
		try{
			obj_Log.Enter_login_data("harshbagul@gmail.com", "123456");
		
			obj_Log.click_Login();
			
			obj_Log.waitforProfileopen();
			
		}catch(NoSuchElementException e){}
			
			if(obj_Log.Verify_Login1()==true){
				
				System.out.println("TC06-->Username or  password Valid, so User should  be Logged in-->Pass");
			}else{
				
				System.out.println("TC06-->Username or  password worng, so User should not be Logged in-->Fail");
			}
		
			obj_Log.waitforProfileopen();
			
			Thread.sleep(10000);
			obj_Log.click_Logout();
	}
	
	
	/*@AfterTest
	public void Browserclose(){
		
		Browsersetup.closebrowser();
		
	}*/
}