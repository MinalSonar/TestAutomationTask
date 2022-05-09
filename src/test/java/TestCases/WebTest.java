package TestCases;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WebTest {
	 public WebDriver driver;
	 WebDriverWait wait;

	 @BeforeTest
	 public void setUp() {
		 System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, 10, 50);
		 driver.get("http://automationpractice.com/index.php");

	 }

	 @Test(priority = 1)
	 public void userSignInTest() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		 SignInPage signInPage = new SignInPage(driver);
		 LogoutPage logoutPage = new LogoutPage(driver);
		 String name ="Firstname"+ " "+ "Lastname";
		 signInPage.enterEmail();
		 signInPage.clickCreateAccount();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
		 signInPage.enterFullName(); //enter first name and last name
		 signInPage.enterFullAddress();
		 signInPage.enterPassword();
		 Select select = new Select(driver.findElement(By.id("days")));
		 select.selectByValue("1");
		 select = new Select(driver.findElement(By.id("months")));
		 select.selectByValue("1");
		 select = new Select(driver.findElement(By.id("years")));
		 select.selectByValue("2000");
		 signInPage.enterAdditionalInfo();
		 signInPage.enterContactDetails();
		 signInPage.enterAlias();
		 signInPage.clickRegister();

		 MyAccountPage myAccountPage = new MyAccountPage(driver);

		 assertTrue(myAccountPage.isPageOpened());
		 assertTrue(myAccountPage.isUserNameDisplayed());
		 assertEquals(name,myAccountPage.getUserName());
		 assertTrue(logoutPage.isLogoutDisplayed());
		 assertTrue(myAccountPage.verifyPageURL());
		 logoutPage.logout();

	 }

	 @Test(priority = 2)
	 public void userLogInTest() {

		 String fullName = "firstuser firstuser";
		 WebElement userLogin =wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
		 LoginPage login = new LoginPage(driver);
		 userLogin.click();
		 login.enterEmail();
		 login.enterPassword();
		 login.clickLogin();
		 MyAccountPage myAccountPage = new MyAccountPage(driver);
		 LogoutPage logoutPage = new LogoutPage(driver);
		 assertTrue(myAccountPage.isPageOpened());
		 assertTrue(myAccountPage.isUserNameDisplayed());
		 assertEquals(fullName,myAccountPage.getUserName());
		 assertTrue(logoutPage.isLogoutDisplayed());
		 assertTrue(myAccountPage.verifyPageURL());
		 logoutPage.logout();

	 }

	 @Test(priority = 3)
	public void checkoutTest() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		 LoginPage login = new LoginPage(driver);
		 login.enterEmail();
		 login.enterPassword();
		 login.clickLogin();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
		 driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
		 driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li//a[@title='Add to cart']"))).click();

		 wait.until(ExpectedConditions.visibilityOfElementLocated(
				 By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();


		 wait.until(ExpectedConditions.visibilityOfElementLocated(
				 By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();


		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();


		 driver.findElement(By.name("processCarrier")).click();


		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button")))
				 .click();

		 OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		 assertTrue(orderConfirmationPage.verifyHeading());
		 assertTrue(orderConfirmationPage.verifyOrderConfirmationText());
		 assertTrue(orderConfirmationPage.verifyLastStep());
		 orderConfirmationPage.verifyPageURL();

	 }

	 @AfterTest
	 public void tearDown() {
	 	driver.close();
	 	driver.quit();
	 }
}
