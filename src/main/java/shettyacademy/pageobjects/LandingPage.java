package shettyacademy.pageobjects;
import shettyacademy.abstractcomp.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LandingPage extends AbstractComponent{
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // WebElement userEmail = driver.findElement(By.id("userEmail"));
    // PageFactory
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement submit;

    @FindBy(className="toast-message")
    WebElement errorMsg;

    public ProductCatalogue loginApplication(String email, String password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submit.click();
        ProductCatalogue catalog = new ProductCatalogue(driver);
        return catalog;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String getErrorMsg(){
        waitForElementToAppear(errorMsg);
        return errorMsg.getText();
    }
}
