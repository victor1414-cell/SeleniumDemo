package shettyacademy.pageobjects;
import org.openqa.selenium.support.ui.ExpectedConditions;
import shettyacademy.abstractcomp.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponent {
    WebDriver driver;
    public CheckOutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@placeholder='Select Country']")
    WebElement country;

    @FindBy(css=".ta-results")
    WebElement autocomplete;

    @FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
    WebElement chosenCountry;

    @FindBy(css=".action__submit")
    WebElement placeOrderBtn;

    @FindBy(id="toast-container")
    WebElement toastMsg;

    public void selectCountry(String countryName){
        country.sendKeys(countryName);
        waitForElementToAppear(autocomplete);
        chosenCountry.click();
    }

    public ConfirmationPage placeOrder(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        js.executeScript("arguments[0].click();", placeOrderBtn);
        ConfirmationPage confirmPage = new ConfirmationPage(driver);
        return confirmPage;
    }

}
