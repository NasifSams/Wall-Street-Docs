package Main;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass {
WebDriver driver;
	
	public  PageObjectClass(WebDriver d) {
		
		driver=d;
		PageFactory.initElements(d, this);
		
	}

	@FindBy(id="search")
	WebElement SearchBar;
	
	public void SelectSearchbar(String search, Keys key) {
		SearchBar.sendKeys(search);
		
		SearchBar.sendKeys(key);
	}
	// validating backpack
	@FindBy(xpath="/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong")
	WebElement product;
	
	//clicking shorts
	@FindBy(xpath="/html/body/div[2]/main/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/a/span/span/img")
	WebElement Shorts;
	
	public void clickingShorts() {
		Shorts.click();
	}
	
	//selecting  Shorts size;
	@FindBy(xpath="/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[3]")
	WebElement ShortsSize;
	public void selectingShortsSize() {
		ShortsSize.click();
	}
	
	//selecting shorts color
	@FindBy(xpath="/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div[1]")
	WebElement ShortsColor;
	public void SelectShortsColor() {
		ShortsColor.click();
	}
	
	//clicking to add to cart
	@FindBy(xpath="/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[2]/button")
	WebElement AddToCartbtn;
	
	public void ClickingAddToCartBTN() {
		AddToCartbtn.click();
	}
	//clicking addtocart
	@FindBy(xpath="/html/body/div[2]/header/div[2]/div[1]/a")
	WebElement AddToCart;
	public void ClickAddToCart() {
		AddToCart.click();
	}
	
	//selecting product name from add to cart for validation.
	@FindBy(xpath="/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[4]/ol/li/div/div/strong/a")
	WebElement ProductName;
	//price
	@FindBy(xpath="/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[4]/ol/li/div/div/div[2]/div[1]/span/span/span/span")
	WebElement Price;
	
	//Quantity
	
	@FindBy(xpath="/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[1]/span[1]")
	WebElement QTY;
}
