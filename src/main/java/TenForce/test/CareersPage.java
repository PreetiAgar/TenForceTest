package TenForce.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage extends AbstractComponent {

	public WebDriver driver;

	public CareersPage (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@data-type='people']")
	WebElement lifeLink;
	
	@FindBy(xpath="//a[contains(@href,'life-of-two-interns')]")
	WebElement twoInterns;
	
	public void clickLifeLink() {
		waitForElementToBeClickable(lifeLink);
		lifeLink.click();
	}
	
	
	public ArticlePage clickLifeArticle() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",twoInterns);
		//waitForElementToBeClickable(twoInterns);
		twoInterns.click();
		return new ArticlePage(driver);
	}
}
