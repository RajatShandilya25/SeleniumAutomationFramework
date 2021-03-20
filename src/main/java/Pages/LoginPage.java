package Pages;

import Initialization.BaseClass;
import Utility.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.IOException;

public final class LoginPage extends BasePage
{

    private final By UsernameTextbox = By.id("txtUsername");
    private final By PwdTextbox = By.id("txtPassword");
    private final By LoginBtn = By.id("btnLogin");



    /*******************    WebElements actions and methods  *****************************/


    /**
     *
     * @return current page title
     */
    public String getPageTitle()
    {
        System.out.println("Title --> " +getCurrentPageTitle());
        return getCurrentPageTitle();
    }

    /**
     * Enter username
     * @param Username is sent from the config.properties file
     */
    public LoginPage enterUsername(String Username)
    {
        sendKeys(UsernameTextbox, Username);
        return this;
    }

    /**
     * Enter Password
     * @param Password is sent from the config.properties file
     */
    public LoginPage enterPassword(String Password)
    {
        sendKeys(PwdTextbox, Password);
        return this;
    }

    /**
     * Click on login button
     */
    public Homepage clickLoginBtn()
    {
        click(LoginBtn);
        return new Homepage();
    }

    public void Login(String Username, String Password) throws IOException
    {
        enterUsername(Username);
        enterPassword(Password);
        clickLoginBtn();
    }

}
