package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FbLoginPage {

    private WebDriver driver;

    public FbLoginPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(id = "email")
    WebElement emailTextBox;

    @FindBy(id = "pass")
    WebElement passwordTextBox;

    @FindBy(id = "loginbutton")
    WebElement signinButton;



    public void setEmail(String strEmail){
        emailTextBox.sendKeys(strEmail);
    }

    public void setPassword(String strPassword){
        passwordTextBox.sendKeys(strPassword);
    }

    public void clickOnLoginButton(){
        signinButton.click();
    }


}
