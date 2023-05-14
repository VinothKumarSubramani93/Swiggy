package baseSwiggy;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilsSwiggy.UtilsClass;

public class BaseClassSwiggy extends UtilsClass {

	@BeforeMethod
	public void start() throws Exception {
		browserLaunch(getPropetyValue("browser"));
		waitImplicit();
		getUrl(getPropetyValue("url"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
