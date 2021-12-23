package PageJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Register extends Base {

	By emailCreate= By.id("email_create");
	By createAccountButton= By.id("SubmitCreate");
	By accountForm = By.id("account-creation_form");
	By gender1= By.id("id_gender1");
	By gender2= By.id("id_gender2");
	By firstName= By.id("customer_firstname");
	By lastName= By.id("customer_lastname");
	By email= By.id("email");
	By passwd= By.id("passwd");
	By days= By.id("days");
	By months= By.id("months");
	By years= By.id("years");
	By newsletter= By.id("newsletter");
	By optin= By.id("optin");
	By firstName2= By.id("firstname");
	By lastName2= By.id("lastname");
	By company= By.id("company");
	By address1= By.id("address1");	
	By address2= By.id("address2");
	By city= By.id("city");
	By state= By.id("id_state");
	By postCode= By.id("postcode");
	By country= By.id("id_country");
	By textArea= By.id("other");
	By phone= By.id("phone");
	By phoneMobile= By.id("phone_mobile");
	By alias= By.id("alias");
	By submitButton= By.id("submitAccount");
	By acount= By.xpath("//a[@class=\"account\"]");
	
	
	public Register(WebDriver driver) {
		super(driver);
	}
	
	public void createAccount(String text) {
		type(emailCreate,text);
		click(createAccountButton);
		//waitIsvisibility(accountForm);
		
	}
	
	public void clickGender(String text) {
		if(text== "Mr.") {
		click(gender1);
		}else click(gender2);
	}
	
	public void setFirstName(String text) {
		type(firstName, text);
	}
	
	public void setLastName(String text) {
		type(lastName, text);
	}
	
	public void checkEmail(String text) {
		Assert.assertEquals(getTextValue(email),text);
	}
	
	public void setPasswd(String text) {
		type(passwd,text);
	}
	
	public void selectDateOfBirth(String day,String month,String year) {
		selectByValue(days,day);
		selectByValue(months,month);
		selectByValue(years,year);
	}
	
	public void clickOpt(String text1,String text2) {
		if(text1== "Yes" && text2 == "Yes") {
		click(newsletter);
		click(optin);
		}else {
			if(text1== "Yes") {
				click(newsletter);
			}else {
				if(text2== "Yes") {
					click(optin);
			}
		}
	}
	}
	
	public void checkName(String fName, String lName) {
		Assert.assertEquals(getTextValue(firstName2), fName);
		Assert.assertEquals(getTextValue(lastName2), lName);
	}
	
	public void setCompany(String text) {
		type(company,text);
	}
	public void setAddress1(String text) {
		type(address1,text);
	}
	
	public void setAddress2(String text) {
		type(address2,text);
	}
	
	public void setadCity(String text) {
		type(city,text);
	}
	
	public void selectState(String text) {
		selectByValue(state,text);
	}
	
	public void setPostCode(String text) {
		type(postCode,text);
	}
	
	public void selectCountry(String text) {
		selectByValue(country,text);
	}
	
	public void setAddInfo(String text) {
		type(textArea,text);
	}
	
	public void setPhone(String text) {
		type(phone,text);
	}
	
	public void setPhoneMobile(String text) {
		type(phoneMobile,text);
	}
	
	public void setAlias(String text) {
		clear(alias);
		type(alias,text);
	}
	
	public void clickSubmitButton() {
		click(submitButton);	
	}
	
	public void checkCreationAccount(String text) {
	//	waitTextToBe(acount, text);
		//Assert.assertEquals(getText(acount),"Daniel Jorge Luis Farias","Register failed.");
	}

}
