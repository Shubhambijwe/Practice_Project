package Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomClasses.AmazonAddToCartPage;
import pomClasses.AmazonBestSellerPage;

public class DemoCrossBrowser {

	// This Cross Browser Testing program not successful because of program issue.
	private	WebDriver driver;
	private AmazonBestSellerPage amazonBestSellerPage;
	private AmazonAddToCartPage amazonAddToCartPage;
		
		
		@Parameters("browser")
		@BeforeTest
		public void openBrowser(String browserName) {
			
			
			if(browserName.equals("Chrome"))
			{
				
				System.out.println("Before Class");
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Hp\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			if(browserName.equals("Edge"))
			{
				
				System.out.println("Before Class");
				System.setProperty("webdriver.edge.driver","C:\\Users\\Hp\\Desktop\\New folder\\edgedriver_win32\\msedgedriver.exe");
				driver=new EdgeDriver();
			}
			
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		@BeforeClass
		public void beforeClass()
		{
			
		 amazonBestSellerPage=new AmazonBestSellerPage(driver);
		 amazonAddToCartPage=new AmazonAddToCartPage(driver);

			

		}
		
		@BeforeMethod
		public void openHomePage() throws InterruptedException {
			System.out.println("Before Method");
			driver.get("https://www.amazon.in/");
//			AmazonBestSellerPage amazonBestSellerPage=new AmazonBestSellerPage(driver);
			Thread.sleep(2000);
			
			amazonBestSellerPage.clickOnBestSell();
			amazonBestSellerPage.clickOnBestSeller();
			
	//		AmazonAddToCartPage amazonAddToCartPage=new AmazonAddToCartPage(driver);
			amazonAddToCartPage.sendSearch();
			
		} 
		
		@Test (priority=1)	
		public void verifybestsellPage() throws InterruptedException {
			System.out.println("Test -1");
	//		AmazonBestSellerPage amazonBestSellPage=new AmazonBestSellerPage(driver);
			Thread.sleep(2000);
			amazonBestSellerPage.clickOnBestSell();
			amazonBestSellerPage.clickOnBestSeller();
			
			
			String actualURL=driver.getCurrentUrl();
			String actualTitle=driver.getTitle();
			String expectedURL="https://www.amazon.in/gp/bestsellers/?ref_=nav_cs_bestsellers";
			String expectedTitle="Amazon.in Bestsellers: The most popular items on Amazon";
			
			if(actualURL.equals(expectedURL)&& actualTitle.equals(expectedTitle))
			{
				System.out.println("PASSED");
			}
			else
			{
				System.out.println("FAILED");
			}
			
		}
		
		@Test (priority=2)	
		public void verifyAddToCartPage() throws InterruptedException {
			System.out.println("Test -2");
		
//			AmazonAddToCartPage amazonAddToCartPage=new AmazonAddToCartPage(driver);
			Thread.sleep(1000);
			amazonAddToCartPage.clickOnsearchIcon();
			
			amazonAddToCartPage.clickOnProductCategory();
			
			amazonAddToCartPage.clickOnAddtoCart();
			
			Thread.sleep(1000);
			
			ArrayList<String>addr=new ArrayList<String>(driver.getWindowHandles());
			
			driver.switchTo().window(addr.get(0));
			
			String actualURL=driver.getCurrentUrl();
			String actualTitle=driver.getTitle();
			String expectedURL="https://www.amazon.in/dp/B0BMGB2TPR/ref=redir_mobile_desktop?_encoding";
			String expectedTitle="Samsung Galaxy M04 Light Green, 4GB RAM, 128GB Storage | Upto 8GB RAM with RAM Plus | MediaTek Helio P35 | 5000 mAh Battery : Amazon.in";
			
			if(actualURL.equals(expectedURL)&& actualTitle.equals(expectedTitle))
			{
				System.out.println("PASSED");
			}
			else
			{
				System.out.println("FAILED");
			}
		}
		
		@AfterMethod
		public void afterMethod()   {
			System.out.println("After Method");
		
		}
		@AfterClass
		public void afterClass() {
			System.out.println("After Class");

		}
		@AfterTest
		public void afterTest() {
			System.out.println("After Test");

		}
		

}
