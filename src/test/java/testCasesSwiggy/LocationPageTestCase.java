package testCasesSwiggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseSwiggy.BaseClassSwiggy;
import pagesSwiggy.HomePageSwiggy;
import pagesSwiggy.LocationPageSwiggy;

public class LocationPageTestCase extends BaseClassSwiggy {
	
	@Test
	public void enterLocation() throws Exception {
		LocationPageSwiggy locationPage=new LocationPageSwiggy();
		locationPage.enterDeleiveyLocation("Chennai");HomePageSwiggy home=new HomePageSwiggy();
		Assert.assertEquals(home.getTitleOfPage(), "Order food online from India's best food delivery service. Order from restaurants near you");
	}
	
	@Test(dataProvider="dataReader")
	public void validateListOfSwiggyCity(String expCity) {
		//WebElement cit=driver.findElement(By.xpath("//ul[@class='_3TE0x']//*[contains(text(),'"+expCity+"')]"));
		LocationPageSwiggy locationPage=new LocationPageSwiggy();
		String actualCity = locationPage.getCity();
		System.out.println("ActualCity : "+actualCity+",ExpCity : "+expCity);
		Assert.assertEquals(actualCity, expCity);
		WebElement city=driver.findElement(By.xpath("//ul[@class='_3TE0x']//*[contains(text(),'"+expCity+"')]"));
		Assert.assertTrue(city.isDisplayed());
	}
	
}
