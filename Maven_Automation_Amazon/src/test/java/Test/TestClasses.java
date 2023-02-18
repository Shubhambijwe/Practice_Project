package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.AmazonAddToCartPage;
import pomClasses.AmazonBestSellerPage;

public class TestClasses {
	public static void main(String[] args) throws InterruptedException 
	{
		//Maven Project is done according to sir requirement.all these things.
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hp\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		
//		JUST CREATE THE OBJECT OF EACH PAGE AND DO PERFORM THE ACTION ON IT.
		
		//object
		
		
		AmazonBestSellerPage amazonHomePage=new AmazonBestSellerPage(driver);
		
		amazonHomePage.clickOnBestSell();		
	
		
		amazonHomePage.clickOnBestSeller();
			
		//object

		
//		
		AmazonAddToCartPage amazonAddToCartPage = new AmazonAddToCartPage(driver);
//		
		amazonAddToCartPage.sendSearch();
//		
		amazonAddToCartPage.clickOnsearchIcon();   
//		
//		
		amazonAddToCartPage.clickOnProductCategory();
//		
		amazonAddToCartPage.clickOnAddtoCart();
//		

	
		
	}

}
