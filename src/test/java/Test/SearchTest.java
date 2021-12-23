package Test;

import org.testng.annotations.Test;

import PageJava.Search;
import Utility.XLUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class SearchTest {
	String path="./src/test/resources/datafiles/loginUsuarios.xlsx";
	String sheetName="Search";
	XLUtility  xlutil=new XLUtility(path);
	
	WebDriver driver;
	Search s;
	
	
  @BeforeMethod
  public void beforeMethod() {
	  s= new Search(driver);
	  driver=s.conectionChromeDriver();
	  driver.manage().window().maximize();
	  s.visit("http://automationpractice.com/index.php");
	  
  }
  
  @Test(description = "Busqueda de un producto sin logeo",dataProvider = "LoginData")
  public void searchTest(String text,String res)throws IOException {
	  s.setProduct(text);
	  s.clickSearchButton();
	  s.checkList(res);  
  }

  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  int f= result.getMethod().getParameterInvocationCount(); 
	 if(!result.isSuccess()) {
	   s.screenshot(result);
	  xlutil.fillRedColor(sheetName, f);
	    }else {
	    	xlutil.fillGreenColor(sheetName, f);
	    }
	 s.quit();
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


