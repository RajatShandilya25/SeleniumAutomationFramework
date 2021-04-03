package Initialization;

import Utility.FrameworkConstants;
import Utility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
     * Objects.nonNull(driver) works same as driver != null.
     * It checks that the driver is not null.
     *
     * Quit and removes the driver
     */
    public static void quitDriver()
    {
        if(Objects.nonNull(getDriver()))
        {
            getDriver().quit();
            driver.remove();
        }
    }


    /*
    Objects.isNull(driver) works same as driver == null.
    It checks that the driver is null.
     */
    public static void initializeDriver(String BrowserName)
    {
        if (BrowserName.equalsIgnoreCase("Chrome") && Objects.isNull(getDriver()))
            {
                WebDriverManager.chromedriver().setup();

                //Remote driver
                if(ReadPropertyFile.readPropertyFile("RunMode").equalsIgnoreCase("Docker"))
                {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName(BrowserType.CHROME);
                    try
                    {
                        BaseClass.setDriver(new RemoteWebDriver(new URL(""), capabilities));
                    }
                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    setDriver(new ChromeDriver());
                }
            }
        else if(BrowserName.equalsIgnoreCase("Firefox") && Objects.isNull(getDriver()))
        {
            WebDriverManager.firefoxdriver().setup();

            //Remote driver
            if(ReadPropertyFile.readPropertyFile("RunMode").equalsIgnoreCase("Docker"))
            {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(BrowserType.FIREFOX);
                try
                {
                    BaseClass.setDriver(new RemoteWebDriver(new URL(""), capabilities));
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
            else
                {
                setDriver(new FirefoxDriver());
            }
        }
        getDriver().get(ReadPropertyFile.readPropertyFile("Url").trim());
        getDriver().manage().timeouts().pageLoadTimeout(FrameworkConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//           getDriver().manage().deleteAllCookies();
    }
}
