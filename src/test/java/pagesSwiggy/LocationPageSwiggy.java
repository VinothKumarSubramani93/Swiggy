package pagesSwiggy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseSwiggy.BaseClassSwiggy;

public class LocationPageSwiggy extends BaseClassSwiggy {

	@FindBy(id = "location")
	WebElement locationTextBox;

	@FindBy(xpath = "//span[text()='FIND FOOD']")
	WebElement findFood;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//a[text()='Sign up']")
	WebElement SignUpButton;

	@FindBy(xpath = "//a[@class='_3zoZ8']")
	List<WebElement> deliveryCityList;

	@FindBy(xpath = "//div[contains(text(),'Enter your delivery location')]")
	WebElement attentionMessage;

	public LocationPageSwiggy() {
		PageFactory.initElements(driver, this);
	}

	public void enterDeleiveyLocation(String deleiveryLocation) {
		typeText(locationTextBox, deleiveryLocation);
		WebElement selectLocation = driver
				.findElement(By.xpath("//button[@tabindex='2']//span[contains(text(),'" + deleiveryLocation + "')]"));
		clickElement(selectLocation);
	}

	public void entrLocWithOutSelecting(String deleiveryLocation) {
		typeText(locationTextBox, deleiveryLocation);
		clickElement(findFood);
	}

	public String getAttentionMessage() {
		return extractText(attentionMessage);
	}

	public String getCity() {
		List<WebElement> cityList = driver.findElements(By.xpath("//a[@class='_3zoZ8']"));
		String cityName = null;
		for (WebElement city : cityList) {
			cityName = extractText(city);
		}
		return cityName;
	}
}
