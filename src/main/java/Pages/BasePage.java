package Pages;

import Initialization.BaseClass;
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

}
