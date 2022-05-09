package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    private WebDriver driver;

    @FindBy(className = "logout")
    WebElement logoutButton;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isLogoutDisplayed(){

        return logoutButton.isDisplayed();
    }

    public void logout(){
        logoutButton.click();
    }
}
