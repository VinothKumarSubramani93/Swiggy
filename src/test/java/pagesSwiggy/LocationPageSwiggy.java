package pagesSwiggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseSwiggy.BaseClassSwiggy;

public class LocationPageSwiggy extends BaseClassSwiggy {
	
	@FindBy(id="location")
	WebElement locationTextBox;
	
	@FindBy(xpath="//span[text()='FIND FOOD']")
	WebElement findFood;
	
	/*
	 * @FindBy(xpath="//button[@tabindex='2']//span[contains(text(),'Chennai')]")
	 * WebElement selectLocation;
	 */
	
	public LocationPageSwiggy() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterDeleiveyLocation(String deleiveryLocation) {
		typeText(locationTextBox, deleiveryLocation);
		WebElement selectLocation=driver.findElement(By.xpath("//button[@tabindex='2']//span[contains(text(),'"+deleiveryLocation+"')]"));
		clickElement(selectLocation);
	}
}
