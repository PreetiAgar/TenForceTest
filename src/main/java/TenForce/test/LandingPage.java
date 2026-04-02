package TenForce.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage extends AbstractComponent  {
	
	public WebDriver driver;

	public LandingPage (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Careers")
	WebElement Careers;
		
	public void goTo() {
		driver.get("https://www.tenforce.com/");
	}


	public void scrollToBottom() {
		//WebElement element = 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public CareersPage clickCareers() {
		waitForElementToAppear(Careers);
		Careers.click();
		return new CareersPage(driver);
	}
	
	
	

	
}
	
	
	
	

