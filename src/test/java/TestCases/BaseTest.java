package TestCases;

import Initialization.BaseClass;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class BaseTest
{
//    static WebDriver driver = BaseClass.getDriver();

    /*
    Private Constructor to stop classes to create object of this class.
    All child classes are extending this class
    so no need to create object.
     */
    protected BaseTest() {}


    @BeforeMethod
    protected abstract void setUp(String browserName) throws IOException;

    @AfterMethod
    protected void tearDown()
    {
        BaseClass.quitDriver();
    }

    protected static void enableCrossBrowser(String BrowserName) throws IOException
    {
        if(BrowserName.equalsIgnoreCase("Chrome"))
        {
            BaseClass.initializeDriver("Chrome");
        }
        else if(BrowserName.equalsIgnoreCase("Firefox"))
        {
            BaseClass.initializeDriver("Firefox");
        }
        else
        {
            BaseClass.initializeDriver("Chrome");
        }
    }


}
