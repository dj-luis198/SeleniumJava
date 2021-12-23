package Test;

import org.testng.annotations.Test;

import PageJava.Register;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class registerTest {
	WebDriver driver;
	Register r;
		
 
  @BeforeMethod
  public void beforeMethod() {
	  r= new Register(driver);
	  driver= r.conectionChromeDriver();
	  driver.manage().window().maximize();
	  r.visit("http://automationpractice.com/index.php?controller=authentication&back=my-account");  
  }
  
  
  @Test(description = "Registro de nuevo usuario con datos validos", timeOut= 15000)
  public void register() {
	  
	  r.createAccount("dj.luis1987@gmail.com");
	  r.clickGender("Mrs.");
	  r.setFirstName("Daniel Jorge Luis");
	  r.setLastName("Farias");
	  r.checkEmail("dj.luis1987@gmail.com");
	  r.setPasswd("Pass1");
	  r.selectDateOfBirth("21","7","2000");
	  r.clickOpt("No", "Yes");
	  r.checkName("Daniel Jorge Luis","Farias");
	  r.setCompany("N/A");
	  r.setAddress1("direccion 1");
	  r.setAddress2("direccion 2");
	  r.setadCity("Ciudad");
	  r.selectState("3");
	  r.setPostCode("40000");
	  r.selectCountry("21");
	  r.setAddInfo("algo");
	  r.setPhone("555555555");
	  r.setPhoneMobile("005554447777") ;
	  r.setAlias("direccion alias");
	  r.clickSubmitButton();
	  r.checkCreationAccount("Daniel Jorge Luis Farias");
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  if(!result.isSuccess()) {
		  r.screenshot(result);
		  }
	 driver.quit();
  }

}
