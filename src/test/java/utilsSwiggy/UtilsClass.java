package utilsSwiggy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilsClass {
	
	public static WebDriver driver;
	
	public static void waitForElement(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForTitle(String pageTitle) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleIs(pageTitle));
	}
	
	public static void browserLaunch(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
	}
	
	public static void getUrl(String url) throws Exception {
		driver.get(url);
	}
	
	public static void waitImplicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void clickElement(WebElement element) {
		waitForElement(element);
		element.click();
	}
	
	public static void typeText(WebElement element, String text) {
		waitForElement(element);
		element.clear();
		element.sendKeys(text);
	}
	
	public static String getPropetyValue(String key) throws Exception {
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/config.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.get(key).toString();
	}
	
	public static String extractText(WebElement element) {
		return element.getText();
	}
	
	public static String getPageTitle() {
		return driver.getTitle();
	}
	
	public static boolean enabledStatus(WebElement element) {
		return element.isEnabled();
	}
	
	public static boolean displayStatus(WebElement element) {
		return element.isDisplayed();
	}
	
	@DataProvider
	public static Object[][] dataReader() throws Exception{
		String excelPath=System.getProperty("user.dir");
		XSSFWorkbook workBook=new XSSFWorkbook(excelPath+"/Excel/Swiggy.xlsx");
		XSSFSheet sheet = workBook.getSheet("CityList");
		int row = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		workBook.close();
		return data;
	}
	
}
