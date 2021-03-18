package Pages;

import Initialization.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class Homepage extends BasePage
{

    private final By WelcomeBtn = By.id("welcome");
    private final By LogoutBtn = By.xpath("//a[contains(text(),'Logout')]");


    
    /*******************    WebElements actions and methods  *****************************/

    /**
     *
     * @return current page title
     */
    public String getPageTitle()
    {
        System.out.println("Title --> " +BaseClass.getCurrentPageTitle());
        return BaseClass.getCurrentPageTitle();
    }

    public Homepage clickWelcomeBtn()
    {
        click(WelcomeBtn);
        return this;
    }

    public LoginPage clickLogoutBtn()
    {
        click(LogoutBtn);
        return new LoginPage();
    }

    public LoginPage logout()
    {
        clickWelcomeBtn();
        clickLogoutBtn();
        return new LoginPage();
    }


}