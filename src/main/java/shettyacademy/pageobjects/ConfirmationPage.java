package shettyacademy.pageobjects;
import org.openqa.selenium.support.PageFactory;
import shettyacademy.abstractcomp.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractComponent {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="h1[class='hero-primary']")
    WebElement confirmMsg;

    @FindBy(id="toast-container")
    WebElement toastMsg;

    public String getConfirmMsg(){
        waitForElementToAppear(toastMsg);
        return confirmMsg.getText();
    }
}
