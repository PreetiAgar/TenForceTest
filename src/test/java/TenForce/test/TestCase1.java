package TenForce.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase1 extends BaseTest{
	WebDriver driver;
	@Test
	public void goToCareers() {
		
		landingPage.scrollToBottom();
		CareersPage careersPage=landingPage.clickCareers();
		careersPage.clickLifeLink();
		ArticlePage articlePage=careersPage.clickLifeArticle();
		articlePage.scrollArticle();
		articlePage.goBackToJobOpenings();
		String text=articlePage.getTextOnOpeningsPage();
		Assert.assertEquals(text,"Feel free to send your CV to jobs@tenforce.com");
	}
}