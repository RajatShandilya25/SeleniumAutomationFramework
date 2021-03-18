package TestCases;

import Initialization.BaseClass;
import Pages.BasePage;
import Pages.Homepage;
import Pages.LoginPage;
import Utility.ReadPropertyFile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomepageTest extends BaseTest
{
    private Homepage Home_Page;
    private LoginPage Login_Page;

    @BeforeMethod
    @Override
    protected void setUp() throws IOException
    {
        BaseClass.initializeDriver();

        Login_Page = new LoginPage();
        Login_Page.Login(ReadPropertyFile.readPropertyFile("Username"), ReadPropertyFile.readPropertyFile("Password"));
        Home_Page = new Homepage();
    }


    /**
     * Validates home page title
     * @throws IOException
     */
    @Test(priority = 1)
    public void validateTitle() throws IOException
    {
        String Title = Home_Page.getPageTitle();
        Assert.assertEquals(Title, ReadPropertyFile.readPropertyFile("HomepageTitle"));
    }


    /**
     * Validates logout functionality and check login page title after successfull logout
     * @throws IOException
     */
    @Test(priority = 2)
    public void validateLogout() throws IOException
    {
        String LoginPageTitle = Home_Page.logout().getPageTitle();
         Assert.assertEquals(LoginPageTitle, ReadPropertyFile.readPropertyFile("LoginpageTitle"));
    }


}