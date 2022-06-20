package Academy;

import PageObjects.LandingPage;
import Resources.base;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateTitle extends base {
    public WebDriver driver;
    @BeforeTest
    public void initialize() throws IOException {

        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test

    public void validateAppTitle () throws IOException
    {

        //two ways to call another class into this
        //1 way is inheritance
        //another is creating object to that class and invoke methods of it
        LandingPage landingPage = new LandingPage(driver);
        //compare the text from the browser with actual text-error
        Assert.assertEquals(landingPage.getTitle().getText(),"Featured Course");
        landingPage.getTitle().getText();

    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }

}
