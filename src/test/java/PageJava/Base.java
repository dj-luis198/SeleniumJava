package PageJava;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

public class Base {

	private WebDriver driver;
	
	public Base(WebDriver driver) {
		
		this.driver= driver;
	}
	
	public WebDriver conectionChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		return driver;
	}
//
	public WebElement webElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> webElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void type(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
		
	}
	// Verifica que los textos son los mismos, espera 10 segundos intervalo de 5
	/*@SuppressWarnings("deprecation")
	public void waitTextToBe(By locator, String text) {
			WebDriverWait wait= new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.textToBe(locator, text));
	}*/
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getTextValue(By locator) {
		return driver.findElement(locator).getAttribute("value");
	}
	
	/*public WebElement waitIsvisibility(By locator) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait= new WebDriverWait(driver,20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}*/
	
	public void selectByValue(By locator, String text) {
		Select var= new Select(webElement(locator));
		var.selectByValue(text);
	}
	
	public void clear(By locator) {
		webElement(locator).clear();
	}
		
	
	
	public void screenshot(ITestResult result) {
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./src/test/resources/screenshot/"+
		result.getMethod().getMethodName()+"_"+result.getMethod().getDescription()+"_"+result.getStartMillis()+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	

	public void quit() {
		driver.quit();
	}
}

