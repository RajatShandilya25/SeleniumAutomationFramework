package TestCases;

import Initialization.BaseClass;
import Pages.BasePage;
import Pages.Homepage;
import Pages.LoginPage;
import Utility.DataProviderUtility;
import Utility.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;


/*
class is final so that other classes can't extend this class
constructor is final so that other classes can't create an object of this class
 */
public final class LoginPageTest extends BaseTest
{
    LoginPage Login_Page;


    //Private constructor
    private LoginPageTest() { }


//    //Overriding BaseTest class methods
//    @Override
//    @BeforeMethod()
//    protected void setUp() throws IOException
//    {
//        BaseClass.initializeDriver("Chrome");
//        Login_Page = new LoginPage();
//    }

    @Override
    @BeforeMethod
    @Parameters({"browserName"})
    protected void setUp(String browserName) throws IOException
    {
        enableCrossBrowser(browserName);
        Login_Page = new LoginPage();
    }

    /**
     * Validates login page title
     * @throws IOException
     */
    @Test(priority = 1)
    public void validateLoginPageTitle() throws IOException
    {
        Assert.assertEquals(Login_Page.getPageTitle(), ReadPropertyFile.readPropertyFile("LoginpageTitle"));
    }


    /**
     * Validates login flow and check home page title after unsuccessful login
     * @throws IOException
     */
    @Test(priority = 2, dataProvider = "getData", dataProviderClass = DataProviderUtility.class)
    public void validateLoginWithIncorrectCredentials(Map<String, String> dataMap) throws IOException
    {
        String HomepageTitle = Login_Page.enterUsername(dataMap.get("Username"))
                .enterPassword(dataMap.get("Password")).clickLoginBtn().getPageTitle();

        Assert.assertEquals(HomepageTitle, ReadPropertyFile.readPropertyFile("HomepageTitle"));
        Assert.assertTrue(false, "Incorrect credentials. Failing explicitly");
    }

    @Test(priority = 3)
    public void validateTest()
    {
        System.out.println("Validate test");
    }

}
