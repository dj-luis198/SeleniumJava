package PageJava;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login extends Base{

	By mail= By.id("email");
	By password= By.id("passwd");
	By submit= By.id("SubmitLogin");
	By acount= By.xpath("//a[@class=\"account\"]");
	By alertLocator= By.xpath("//div[@class=\"alert alert-danger\"]");
	By signOut= By.linkText("Sign out");
	
	public Login(WebDriver driver) {
		super(driver);
		
	}
	
	public void setEmail(String email) {
		type(mail,email);
	}
	
	public void setPassword(String pass) {
		type(password,pass);
	}
	
	public void clickSubmit() {
		click(submit);
	}
	
	public void checkLogin(String res) throws IOException {
		String exp_title= "My account - My Store";
		String act_title= getTitle();
		if(res.equals("Valid")) {
			if(exp_title.equals(act_title)) {
				click(signOut);
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);	
			}
		}else {
			if(res.equals("Invalid")) {
				if(exp_title.equals(act_title)) {
					click(signOut);
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
					
				}
			}
		}
		
	}
	
	
}
