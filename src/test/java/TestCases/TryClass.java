package TestCases;

import Initialization.BaseClass;
import org.openqa.selenium.WebDriver;

/**
 * @author Rajat Shandilya
 * @time 18/05/21 8:01 PM
 */
public class TryClass
{
    public static void main(String[] args)
    {
        WebDriver driver =  BaseClass.getDriver();
        driver.get("");
    }

}
