package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

  private WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="passwd")
    WebElement password;

    @FindBy(id="SubmitLogin")
    WebElement login_Button;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
   public void enterEmail(){
        email.sendKeys("user1@guerrillamail.com");
    }

    public void enterPassword(){
        password.sendKeys("User123#");
    }

    public void clickLogin(){
        login_Button.click();
    }

}
