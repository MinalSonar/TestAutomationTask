package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;

    @FindBy(tagName="h1")
    WebElement heading;

    @FindBy(className = "account")
    WebElement userAccountName;

    @FindBy(className = "info-account")
    WebElement infoAccount;

    /*@FindBy(className = "logout")
    WebElement logoutButton;*/

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public boolean isUserNameDisplayed(){
        return userAccountName.isDisplayed();
    }

    public String getUserName(){
      return userAccountName.getText();
    }

    public boolean isPageOpened(){
        return heading.getText().toString().equals("MY ACCOUNT");
    }

    /*public boolean isLogoutDisplayed(){
       return LogoutPage.logoutButton.isDisplayed();
    }*/

    public boolean verifyPageURL(){
        return driver.getCurrentUrl().contains("controller=my-account");
    }


}
