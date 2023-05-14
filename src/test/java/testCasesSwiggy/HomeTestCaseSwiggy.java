package testCasesSwiggy;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseSwiggy.BaseClassSwiggy;
import pagesSwiggy.HomePageSwiggy;
import pagesSwiggy.LocationPageSwiggy;

public class HomeTestCaseSwiggy extends BaseClassSwiggy {
	
	@Test
	public void validateSignInButton() {
		LocationPageSwiggy locationPage=new LocationPageSwiggy();
		locationPage.enterDeleiveyLocation("Chennai");
		HomePageSwiggy home=new HomePageSwiggy();
		Assert.assertEquals(home.getTitleOfPage(), "Order food online from India's best food delivery service. Order from restaurants near you");
	}
	
	@Test
	public void validateSignInPresent() {
		LocationPageSwiggy locationPage=new LocationPageSwiggy();
		locationPage.enterDeleiveyLocation("Chennai");
		HomePageSwiggy home=new HomePageSwiggy();
		Assert.assertTrue(home.signInButtonPresent());
	}
}
