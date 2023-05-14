package pagesSwiggy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseSwiggy.BaseClassSwiggy;

public class HomePageSwiggy extends BaseClassSwiggy {
	
	@FindBy(xpath="//span[text()='Sign In']")
	WebElement signInButton;
	
	public HomePageSwiggy() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleOfPage() {
		return getPageTitle();
	}
	
	public void goToSignInPage() {
		clickElement(signInButton);
	}
	
	public boolean signInButtonPresent() {
		return displayStatus(signInButton);
	}
	
}
