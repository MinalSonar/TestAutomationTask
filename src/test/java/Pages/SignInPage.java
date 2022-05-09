package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class SignInPage {

    private WebDriver driver;
    WebDriverWait wait;
    String timestamp = String.valueOf(new Date().getTime());
    String email = "user1_" + timestamp + "@gmail" + timestamp.substring(7) + ".com";
    String name = "Firstname";
    String surname = "Lastname";

    @FindBy(id="email_create")
    WebElement createEmail;

    @FindBy(id="SubmitCreate")
    WebElement submitCreate;

    @FindBy(id="id_gender2")
    WebElement gender;

    @FindBy(id="customer_firstname")
    WebElement firstName;

   @FindBy(id="customer_lastname")
    WebElement lastName;

    @FindBy(id="passwd")
    WebElement password;

   @FindBy(id="company")
    WebElement company;

   @FindBy(id="address1")
    WebElement address1;

   @FindBy(id="address2")
    WebElement address2;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="id_state")
    WebElement idState;

    @FindBy(id="postcode")
    WebElement postcode;

    @FindBy(id="other")
    WebElement other;

    @FindBy(id="phone")
    WebElement phone;

    @FindBy(id="phone_mobile")
    WebElement phoneMobile;

    @FindBy(id="alias")
    WebElement alias;

    @FindBy(id="submitAccount")
    WebElement submitAccount;


    public SignInPage(WebDriverWait wait) {
        this.wait = wait;
    }

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterEmail(){
        createEmail.sendKeys(email);
    }

    public void clickCreateAccount(){
        submitCreate.click();
    }

    public void selectGender(){
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
    }

    public void enterFullName(){
        firstName.sendKeys(name);
        lastName.sendKeys(surname);
    }

    public void enterPassword(){
       password.sendKeys("123456");
    }

    public void enterFullAddress(){
        company.sendKeys("company");
        address1.sendKeys("address1");
        address2.sendKeys("address2");
        city.sendKeys("city");
        Select select =new Select(idState);
        select.selectByVisibleText("Colorado");
        postcode.sendKeys("12345");

    }

    public void enterAdditionalInfo(){
        other.sendKeys("Additional Information");
    }

    public void enterContactDetails(){
        phone.sendKeys("1234567890");
        phoneMobile.sendKeys("1234567890");
    }

    public void enterAlias(){
        alias.clear();
        alias.sendKeys("alias");
    }

    public void clickRegister(){
        submitAccount.click();
    }

   /* public String getUserName(String fullName){
        return firstName.getText() + "" + lastName.getText();
        //return fullName;
    }*/



}
