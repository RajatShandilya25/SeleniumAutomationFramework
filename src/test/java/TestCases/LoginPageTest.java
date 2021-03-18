package TestCases;

import Initialization.BaseClass;
import Pages.BasePage;
import Pages.LoginPage;
import Utility.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


/*
class is final so that other classes can't extend this class
constructor is final so that other classes can't create an object of this class
 */
public final class LoginPageTest extends BaseTest
{
    LoginPage Login_Page;


    //Private constructor
    private LoginPageTest() { }

    //Overriding BaseTest class methods
    @Override
    @BeforeMethod
    protected void setUp() throws IOException
    {
        BaseClass.initializeDriver();
        Login_Page = new LoginPage();
    }

    /**
     * Validates login page title
     * @throws IOException
     */
    @Test(priority = 1)
    public void validateTitle() throws IOException
    {
        Assert.assertEquals(Login_Page.getPageTitle(), ReadPropertyFile.readPropertyFile("LoginpageTitle"));
    }


    /**
     * Validates login flow and check home page title after successful login
     * @throws IOException
     */
    @Test(priority = 2)
    public void validateLogin() throws IOException
    {
        String HomepageTitle = Login_Page.enterUsername("Admin").enterPassword("admin123").clickLoginBtn().getPageTitle();

        Assert.assertEquals(HomepageTitle, ReadPropertyFile.readPropertyFile("HomepageTitle"));
    }



}
