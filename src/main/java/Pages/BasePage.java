package Pages;

import Initialization.BaseClass;
import Utility.SeleniumUtility;
import org.openqa.selenium.By;

public class BasePage
{
    protected BasePage() {}

    /**
     * Clicks on the web element
     * @param by
     */
    protected void click(By by)
    {
        SeleniumUtility.WaitTillElementIsClickable(by);
        BaseClass.getDriver().findElement(by).click();
    }

    /**
     * Send keys to the web element
     * @param by
     * @param keysToSend : Keys to send
     */
    protected void sendKeys(By by, String keysToSend)
    {
        BaseClass.getDriver().findElement(by).sendKeys(keysToSend);
    }


    /**
     * @return current page title
     */
    protected static String getCurrentPageTitle()
    {
        System.out.println("Title --> " +BaseClass.getDriver().getTitle());
        return BaseClass.getDriver().getTitle();
    }
}
