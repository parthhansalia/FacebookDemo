package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FbHomePage {

    WebDriver driver;



    public FbHomePage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(name = "xhpc_message")
    WebElement statusTextBox;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div[3]/div/div/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[3]/div[2]/button/span")
    WebElement postButton;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div[5]/div/div/div[2]")
    WebElement homePage;


    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div[6]/div/div[1]/div/div[2]/div[1]/div[2]/div[2]/div")
    WebElement statusMessage;

    public void postTheStatus(String status) {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(statusTextBox));
        statusTextBox.sendKeys(status);
        wait.until(ExpectedConditions.visibilityOf(postButton));
        postButton.click();

        //Here if you are unable to see the status, May because of internet speed. So here also we can use implicit wait.
        wait.until(ExpectedConditions.visibilityOf(statusMessage));

    }

    public String statusMessage() {
        return statusMessage.getText();
    }




}



