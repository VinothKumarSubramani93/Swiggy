package testCasesSwiggy;

import org.testng.annotations.Test;

import baseSwiggy.BaseClassSwiggy;
import pagesSwiggy.LocationPageSwiggy;

public class LocationPageTestCase extends BaseClassSwiggy {
	
	@Test
	public void enterLocation() {
		LocationPageSwiggy locationPage=new LocationPageSwiggy();
		locationPage.enterDeleiveyLocation("Chennai");
	}
}
