package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FbHomePage;
import pages.FbLoginPage;

public class FbLoginTest extends TestBase {

    private static final String userName = "abc@gmail.com";
    private static final String userPass = "abc@123";
    private static final String status = "Hello World";



    @Test(priority = 1)
    public void loginToFaceBook() {

        FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
        loginpage.setEmail(userName);
        loginpage.setPassword(userPass);
        loginpage.clickOnLoginButton();


    }

    @Test(priority = 2, dependsOnMethods = "loginToFaceBook")
    public void postAndVerifyStatusMessage() {

        FbHomePage homepage = PageFactory.initElements(driver, FbHomePage.class);

        //Post a message
        homepage.postTheStatus(status);

        //Verify the message
        Assert.assertEquals(homepage.statusMessage(), status);

    }



}
