package TenForce.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage extends AbstractComponent {

	public WebDriver driver;

	public ArticlePage (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@data-type='job']")
	WebElement jobOpenings;
	
	@FindBy(xpath="//div[@class='h4']/span[1]")
	WebElement element1;
	
	@FindBy(xpath="//div[@class='h4']/span[2]")
	WebElement element2;
	
 public void scrollArticle() {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 for(int i=0;i<10;i++) {
		js.executeScript("window.scrollBy(0,500);");
	 }
 }
 public void scrollUp() {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("window.scrollTo({top: 0,behavior: 'smooth'})");
	 
 }
 
 public void goBackToJobOpenings() {
	 driver.navigate().back();
	 scrollUp();
	 waitForElementToBeClickable(jobOpenings);
	 jobOpenings.click();
	 
 }
 public String getTextOnOpeningsPage() {
  String s1=element1.getText();
  String s2=element2.getText();
  return s1+" "+s2;
 }
}
