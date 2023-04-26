package shettyacademy.stepDefinitions;
import org.testng.Assert;
import shettyacademy.pageobjects.*;
import shettyacademy.testcomponents.*;

import java.io.IOException;
import io.cucumber.java.en.*;

public class StepDefinitionImpl extends BaseTest {
    LandingPage landingPage;
    ProductCatalogue catalog;
    ConfirmationPage confirmPage;
    @Given("I landed on ecommerce page")
    public void landed_on_ecommerce_page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("Logged in with username (.+) and password (.+)$")
    public void logged_in_username_password(String username, String password){
        catalog = landingPage.loginApplication(username, password);
    }

    @When("I add product (.+) to Cart$")
    public void add_product_to_cart(String productName) throws InterruptedException {
        catalog.addToCart(productName);
    }

    @When("Checkout (.+) and submit the order$")
    public void checkout_and_submit_order(String productName){
        MyCartPage cartPage = catalog.goToMyCart();
        Assert.assertTrue(cartPage.verifyProductDisplay(productName));
        // Check out
        CheckOutPage checkout = cartPage.goToCheckOut();
        checkout.selectCountry("indi");
        confirmPage = checkout.placeOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void msg_displayed_confirmPage(String string){
        Assert.assertEquals(confirmPage.getConfirmMsg(), string);
        driver.quit();
    }

}
