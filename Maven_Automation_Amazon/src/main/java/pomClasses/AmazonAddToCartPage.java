package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonAddToCartPage {
	@FindBy(xpath="//input[@type='text']")
	private WebElement search;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchIcon ;

	@FindBy(xpath="//img[contains(@alt,'Samsung Galaxy M04 Light Green,')]")
	private WebElement productCategory ;

	@FindBy(xpath="//input[@name='submit.add-to-cart']")
	private WebElement addtocart;
	
	// Constructor
	
	public AmazonAddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Methods
	
	
	public void sendSearch() {
		 search.sendKeys("Samsung Galaxy A50");
	}
	public void clickOnsearchIcon() {
		searchIcon.click();
	}
	public void clickOnProductCategory() {
		productCategory.click();
	}
	public void clickOnAddtoCart() {
		addtocart.click();
	}
	
}
