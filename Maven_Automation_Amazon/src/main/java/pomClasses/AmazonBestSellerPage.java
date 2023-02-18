package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonBestSellerPage {
	@FindBy(xpath="(//a[text()='Best Sellers'])[1]")
	private WebElement  bestsell;
	
	@FindBy(xpath="//h2[text()='Bestsellers in Music']")
	private WebElement  bestsellerProduct;
	
	//Constructor
	public AmazonBestSellerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void clickOnBestSell() {
		 bestsell.click();
	}
	public void clickOnBestSeller() {
		bestsellerProduct.click();
	}
	
}
