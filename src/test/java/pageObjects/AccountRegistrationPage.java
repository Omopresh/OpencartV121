package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends BasePage{

  public AccountRegistrationPage(WebDriver driver)
  {
	  super(driver);
  }
	
@FindBy(xpath="//input[@id='input-firstname']")	
WebElement txtFirstname;	
	
@FindBy(xpath="//input[@id='input-lastname']")	
WebElement txtLastname;	
	
@FindBy(xpath="//input[@id='input-email']")	
WebElement txtEmail;	

@FindBy(xpath="//input[@id='input-telephone']")	
WebElement txtTelephone;
	
@FindBy(xpath="//input[@id='input-password']")	
WebElement txtPassword;	
	
@FindBy(xpath="//input[@id='input-confirm']")	
WebElement txtConfirmPassword;	
	
@FindBy(xpath="//input[@name='agree']")	
WebElement chkbPolicy;	
	
@FindBy(xpath="//input[@value='Continue']")	
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")	
WebElement msgConfirmation;




	
public void setFirstName(String fname) {
    txtFirstname.sendKeys(fname);
}



public void setLastName(String lname) {
      txtLastname.sendKeys(lname);
}


public void setEmail(String email) {
    txtEmail.sendKeys(email);
}

public void setTelephone(String tel) {
    txtTelephone.sendKeys(tel);
}


public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}

public void setConfirmPassword(String pwd) {
	 txtConfirmPassword.sendKeys(pwd);
}


public void setPrivacyPolicy() {
	 chkbPolicy.click();
}

public void clickContinue() {
	btnContinue.click();

	//solution1
	//btnContinue.click();
	
	//solution2
	//btnContinue.submit();
	
	//solution3
	//Actions act=new Actions(driver);
	//act.movToElement(btncontinue).click().perorm();
	
	//solution4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btnContinue);
	
	//solution5
	//btnContinue.sendKeys(keys.RETURN);
	
	//solution6
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.untill(ExpectedConditions.elementToBeClickable(btnContinue)).click();			
}


public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	}catch (Exception e) {
		return (e.getMessage());
	}
}














}
