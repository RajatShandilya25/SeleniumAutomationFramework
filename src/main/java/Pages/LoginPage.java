package Pages;

import Initialization.BaseClass;
import Utility.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public final class LoginPage extends BasePage
{

    private final By UsernameTextbox = By.id("txtUsername");
    private final By PwdTextbox = By.id("txtPassword");
    private final By LoginBtn = By.id("btnLogin");



    /**
     * Initializing Page factory
     */
//    public LoginPage()
//    {
////        super();
//        PageFactory.initElements(BaseClass.getDriver(), this);
//    }


    /**************************    WebElements actions and methods  ************************************************/


    /**
     *
     * @return current page title
     */
    public String getPageTitle()
    {
        System.out.println("Title --> " +BaseClass.getCurrentPageTitle());
        return BaseClass.getCurrentPageTitle();
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