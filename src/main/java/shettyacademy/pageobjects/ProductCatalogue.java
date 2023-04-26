package shettyacademy.pageobjects;
import shettyacademy.abstractcomp.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends AbstractComponent{
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(id="toast-container")
    WebElement toastMsg;

    @FindBy(css=".ng-animating")
    WebElement spinner;

    By addToCartBtn = By.cssSelector(".card-body button:last-of-type");

    public List<WebElement> getProductList(){
        // wait for element to appear
        return products;
    }

    public WebElement getProductByName(String productName){
        WebElement prod = products.stream().filter(product
                -> product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addToCart(String productName) throws InterruptedException {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCartBtn).click();
        waitForElementToAppear(toastMsg);
        Thread.sleep(1000);
    }
}
