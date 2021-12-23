package Test;

import org.testng.annotations.Test;
import PageJava.Login;
import Utility.XLUtility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class loginTest {
	public WebDriver driver;
	public Login l;
	String path="./src/test/resources/datafiles/loginUsuarios.xlsx";
	String sheetName="Log";
	XLUtility  xlutil=new XLUtility(path);

@BeforeMethod
  public void beforeMethod() {
	l= new Login(driver);
	driver= l.conectionChromeDriver();
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	l.visit("http://automationpractice.com/index.php?controller=authentication&back=my-account");
  }
  
  @Test(description = "Login de usuarios",timeOut= 15000,dataProvider = "LoginData")
  public void login(String email,String pass, String res) throws IOException {
	  l.setEmail(email);
	  l.setPassword(pass);
	  l.clickSubmit();
	  l.checkLogin(res);

  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  int f= result.getMethod().getParameterInvocationCount(); 
	 if(!result.isSuccess()) {
	   l.screenshot(result);
	  xlutil.fillRedColor(sheetName, f);
	    }else {
	    	xlutil.fillGreenColor(sheetName, f);
	    }
	  l.quit();
  }
  
  @DataProvider(name = "LoginData")
  public String [][] getData() throws IOException{	
	  int totalrows= xlutil.getRowCount(sheetName);
	  int totalcols= xlutil.getCellCount(sheetName,1);
	 String loginData[][]=new String[totalrows][totalcols];
	  for(int i=1;i<=totalrows;i++){
		  for(int j=0;j<totalcols;j++) {
			  loginData[i-1][j]= xlutil.getCellData(sheetName, i, j); 
		  }
	  } 
	  return loginData;
	  
  }

}
