package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {


    private WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(xpath = "//p[@class='cheque-indent']")
    WebElement orderConfirmationText;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    WebElement lastStep;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyHeading(){
        return heading.isDisplayed();
    }
    public boolean verifyOrderConfirmationText(){
        return heading.getText().contains("ORDER CONFIRMATION");
    }

    public boolean verifyPageURL() {
        return driver.getCurrentUrl().contains("controller=order-confirmation");
    }

    public boolean verifyLastStep(){
        return lastStep.isDisplayed();
    }
}
