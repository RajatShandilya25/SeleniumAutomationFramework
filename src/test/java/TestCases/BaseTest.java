package TestCases;

import Initialization.BaseClass;
import org.openqa.selenium.WebDriver;
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


//    @BeforeTest
    @BeforeMethod
    protected abstract void setUp() throws IOException;

//    @AfterTest
    @AfterMethod
    protected void tearDown()
    {
        BaseClass.quitDriver();
    }



}
