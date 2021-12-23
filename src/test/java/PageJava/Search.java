package PageJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Search extends Base{

	//@FindBy(id="search_query_top")
	//WebElement searchLocator;
	By searchLocator= By.id("search_query_top");
	//@FindBy(xpath="//button[@name=\"submit_search\"]")
	//WebElement searchButton;
	By searchButton= By.xpath("//button[@name=\"submit_search\"]");
	//@FindBy(xpath="//h1[@class=\"page-heading  product-listing\"]/span[2]")
	//WebElement textLocator;
	By textLocator= By.xpath("//h1[@class=\"page-heading  product-listing\"]/span[2]");
	//@FindBy(xpath="//div[@id=\"center_column\"]/ul/li")
	//WebElement listResult;
	By listResult= By.xpath("//div[@id=\"center_column\"]/ul/li");
	
	public Search(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	public void setProduct(String text) {
		type(searchLocator,text);
	}
	
	public void clickSearchButton() {
		click(searchButton);
	}
	
	public void checkList(String res) {	
		String a= webElements(listResult).size()+"";
		if(res.equals(webElements(listResult).size()+"")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false,"Se esperaba: "+ res+ " " + "y se obtuvo: "+ a);
		}
		
	}

}
