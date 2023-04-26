package shettyacademy.abstractcomp;
import shettyacademy.pageobjects.*;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AbstractComponent {
    WebDriver driver;
    public AbstractComponent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[routerlink*='cart']")
    WebElement cartIcon;

    @FindBy(css="[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForElementToAppear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitForElementToDisappear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public MyCartPage goToMyCart(){
        cartIcon.click();
        MyCartPage cartPage = new MyCartPage(driver);
        return cartPage;
    }

    public OrderPage goToOrdersPage(){
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }
}
