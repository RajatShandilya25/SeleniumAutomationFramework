package Pages;

import Initialization.BaseClass;
import org.openqa.selenium.By;

public class BasePage
{
    protected BasePage() {}

    
    protected void click(By by)
    {
        BaseClass.getDriver().findElement(by).click();
    }

    protected void sendKeys(By by, String keysToSend)
    {
        BaseClass.getDriver().findElement(by).sendKeys(keysToSend);
    }

}
