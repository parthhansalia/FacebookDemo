package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver = null;

    private final String URL = "https://www.facebook.com";

    @BeforeSuite
    public void initialize() throws IOException {

        ChromeOptions coptions = new ChromeOptions();
        coptions.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "/Users/parthhansalia/IdeaProjects/SampleDemo/chromedriver");
        driver = new ChromeDriver(coptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

    }

    @AfterSuite
    //Test cleanup
    public void TeardownTest()
    {
        TestBase.driver.quit();
    }

}
