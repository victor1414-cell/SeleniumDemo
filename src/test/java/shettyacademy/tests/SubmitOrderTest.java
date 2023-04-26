package shettyacademy.tests;
import shettyacademy.pageobjects.*;
import shettyacademy.testcomponents.*;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test
    public void submitOrder() throws IOException, InterruptedException {

        // Log in
        ProductCatalogue catalog = landingPage.loginApplication("shetty@gmail.com","Iamking@000");
        // Add product to cart
        catalog.addToCart(productName);
        MyCartPage cartPage = catalog.goToMyCart();
        Assert.assertTrue(cartPage.verifyProductDisplay(productName));
        // Check out
        CheckOutPage checkout = cartPage.goToCheckOut();
        checkout.selectCountry("indi");
        ConfirmationPage confirmPage = checkout.placeOrder();
        Assert.assertEquals(confirmPage.getConfirmMsg(),"THANKYOU FOR THE ORDER.");
    }

    @Test(dependsOnMethods={"submitOrder"})
    public void orderHistoryTest(){
        ProductCatalogue catalog = landingPage.loginApplication("shetty@gmail.com","Iamking@000");
        OrderPage ordersPage = catalog.goToOrdersPage();
        Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
    }

}
