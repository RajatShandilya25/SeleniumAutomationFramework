package Initialization;

import Utility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


/*
class is final so that other classes can't extend this class
constructor is final so that other classes can't create
an object of this class
 */
public final class BaseClass
{

    /*
    Private Constructor to stop classes to create object of this class.
    All child classes are extending this class
    so no need to create object.
     */
    private BaseClass() {}

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    /**
     * @return driver
     */
    public static WebDriver getDriver()
    {
        return driver.get();
    }

    /**
     * set the driver
     * @param Driver
     */
    public static void setDriver(WebDriver Driver)
    {
        driver.set(Driver);
    }

    /**
     * Quit and removes the driver
     */
    public static void removeDriver()
    {
        getDriver().quit();
        driver.remove();
    }

    /*
   Objects.nonNull(driver) works same as driver != null.
   It checks that the driver is not null.
    */
    public static void quitDriver()
    {
        if(Objects.nonNull(getDriver()))
        {
            removeDriver();
        }
    }


    /*
    Objects.isNull(driver) works same as driver == null.
    It checks that the driver is null.
     */
    public static void initializeDriver() throws IOException
    {
       if(Objects.isNull(getDriver()))
       {
           WebDriverManager.chromedriver().setup();
           setDriver(new ChromeDriver());
           getDriver().get(ReadPropertyFile.readPropertyFile("url").trim());
           getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//           getDriver().manage().deleteAllCookies();
       }
    }


}
