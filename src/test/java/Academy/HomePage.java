package Academy;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends base {
    public WebDriver driver;
    @BeforeTest
    public void initialize() throws IOException {

        driver=initializeDriver();
    }

    @Test(dataProvider = "getData")

    public void basePageNavigation (String Username,String password, String text) throws IOException {
        driver.get(prop.getProperty("url"));
        LandingPage landingPage = new LandingPage(driver);
        //two ways to call another class into this
        //1 way is inheritance
        //another is creating object to that class and invoke methods of it
        landingPage.getLogin().click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(Username);
        loginPage.getPassword().sendKeys(password);
        System.out.println(text);
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
    @DataProvider
    public Object[][] getData ()
    {
        //Raw stands for how many different data types tests should run
        Object[][] data = new Object[2][3];
        data[0][0]="nonrestricteduser@qw.com";
        data[0][1]="123456";
        data[0][2]="Restricted User";

        data[1][0]="nonrestricteduser@qw.com";
        data[1][1]="123456";
        data[1][2]="Restricted User";

        return data;

    }
}
