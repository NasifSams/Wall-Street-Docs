package Main;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class mainTestClass {

	WebDriver driver;
	ExtentReports extent;
	
	@BeforeSuite
	public void ExtentSetUp() {
		extent= new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("MyTestReport.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Web Testing Automation Assessment");
		spark.config().setReportName("Nasif Sadiq");
		extent.attachReporter(spark);
		
		
	   
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		  System.setProperty("C:\\eclipse\\chrome-win64\\chrome.exe\"", "C:\\eclipse");
		     driver= new ChromeDriver();
		//System.setProperty("driver.firfox.mariontee", "C:\\eclipse");
		//  driver= new FirefoxDriver();
		  driver.get("https://magento.softwaretestingboard.com/");
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  //Thread.sleep(2000);
		  String Exp_Title="Home Page";
		  String Act_Title=driver.getTitle();
		  Assert.assertEquals(Exp_Title, Act_Title);
		  
	}
	
	
	@Test (priority=1)
	public void SearchFunctionality() {
		ExtentTest test=extent.createTest("Search Functionality","WallStreetDocs Ltd").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
		PageObjectClass pm= new PageObjectClass(driver);
		
		pm.SelectSearchbar("Fusion Backpack",Keys.ENTER);
		test.info("Fusion Backpack has been written in searchbar");
		
		pm.product.getText();
		if(pm.product.getText().contains("Fusion Backpack")) {
			
			test.pass("Searched Product Found" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			
		}
		else {
			test.fail("Searched Product is not Found" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		

		
		
	}
	
	@Test(priority=2)
	public void AddtoCartandRemove() throws InterruptedException {
ExtentTest test=extent.createTest("Add to Cart and Remove","WallStreetDocs Ltd").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
		PageObjectClass pm= new PageObjectClass(driver);
		
		pm.SelectSearchbar("Orestes Fitness Short",Keys.ENTER);
		test.info("Orestes Fitness Short has been written in searchbar");
		
		pm.clickingShorts();
		test.info("visiting Orestes Fitness Short's deatils page");
		
		pm.selectingShortsSize();
		test.info("Short size 34");
		
		pm.SelectShortsColor();
		test.info("shorts color= black");
		
		pm.ClickingAddToCartBTN();
		test.info("Clicking to add to cart btn");
		
		Thread.sleep(2000);
		
		pm.ClickAddToCart();
		test.info("Clciking add to cart");
		
		Thread.sleep(2000);
		
		pm.ProductName.getText();
		
		Thread.sleep(2000);
		
		if(pm.ProductName.getText().contains("Orestes Fitness Short")) {
			test.pass("Product is in cart" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			
		}
		else {
			test.fail( "Product is not Found in cart" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		Thread.sleep(2000);
		
		if(pm.Price.getText().contains("$35.00")&& pm.QTY.getText().contains("1")) {
			test.pass("Product is in cart" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
			
		}
		else {
			test.fail( "Product is not Found in cart" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		
		
	}

	
	
	@AfterMethod
	public void tearDown1() {
		
		driver.close();
		driver.quit();
		
	}
	@AfterSuite
	public void tearDwon() {
		extent.flush();
		
	}
	public String getBase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

}
