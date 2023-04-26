package shettyacademy.pageobjects;
import shettyacademy.abstractcomp.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyCartPage extends AbstractComponent{
    WebDriver driver;
    public MyCartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(xpath="//button[contains(text(),'Checkout')]")
    WebElement checkoutBtn;

    public boolean verifyProductDisplay(String productName){
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckOutPage goToCheckOut(){
        checkoutBtn.click();
        CheckOutPage checkout = new CheckOutPage(driver);
        return checkout;
    }

}
