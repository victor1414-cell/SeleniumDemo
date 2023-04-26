package shettyacademy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import shettyacademy.pageobjects.*;
import shettyacademy.testcomponents.BaseTest;

import java.io.IOException;

public class ErrorValidation extends BaseTest {
    @Test
    public void LoginErrorValidation() throws IOException, InterruptedException {
        ProductCatalogue catalog = landingPage.loginApplication("shetty@gmail.com","Iamking@");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMsg().trim());
    }

    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException {
        System.out.println("Product error validation");
    }
}
