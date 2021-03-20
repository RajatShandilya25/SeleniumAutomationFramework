package Utility;

import Initialization.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SeleniumUtility {
    public static JavascriptExecutor js;
    public static WebDriverWait wait;
    public static Actions actions;
    public static Select select;

    /************************* MOUSE OVER ************************************************/

    public static void MouseOver(WebElement element)
    {
        actions = new Actions(BaseClass.getDriver());
        actions.moveToElement(element).build().perform();
    }

    /***************************** MOUSEOVER AND CLICK ********************************************/

    public static void MouseHoverAndClick(WebElement element) {
        actions = new Actions(BaseClass.getDriver());
        actions.moveToElement(element).click().build().perform();

    }

    /***************************** SEND KEYS ********************************************/

    public static void SendKeysUsingActionClass(WebElement element, String SengKeys) {
        actions = new Actions(BaseClass.getDriver());
        actions.sendKeys(element, SengKeys).perform();

    }


    /******************************** SCROLL BY PIXEL *****************************************/

    public static void ScrollToTheBottomByPixel() {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    /******************************* SCROLL BY TIME ******************************************/

    public static void ScrollToTheBottomByTime(int TimeInSeconds) throws InterruptedException {
        js = (JavascriptExecutor) BaseClass.getDriver();

        for (int seconds = 0; ; seconds++) {
            if (seconds >= TimeInSeconds) {
                break;
            }
            js.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(3000);

        }
    }


    /******************************* SCROLL TO ELEMENT ******************************************/

    public static void ScrollToTheElement(WebElement Element) {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", Element);
//		js.executeScript("arguments[0].click()", Element);
    }


    /******************************* SCROLL TO ELEMENT AND CLICK ******************************************/

    public static void ScrollToTheElementAndClickUsingJS(WebElement Element) {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("arguments[0].click()", Element);
    }

    /******************************* SCROLL TO ELEMENT AND CLICK ******************************************/

    public static void ScrollToTheElementAndClick(WebElement Element) {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("arguments[0].click()", Element);
    }

    /******************************* SCROLL TILL ELEMENT IS VISIBLE ******************************************/

    public static void ScrollTillElementIsVisible(WebElement Element) {
        while (!Element.isDisplayed()) {
            js = (JavascriptExecutor) BaseClass.getDriver();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        }

    }

    /***************************** SEND KEYS USING JAVA SCRIPT EXECUTOR ****************************************/

    public static void SendKeysUsingJS(WebElement WebElementId, String SearchText) {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("document.getElementById('" + WebElementId + "').value='" + SearchText + "';");

    }


    /***************************** SELECT DATE ON CALENDAR ****************************************/

    public static void SetAttribute(WebElement element, String ValueToSet) {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + ValueToSet + "')", element);
    }

    /***************************** DRAW BORDER *********************************************/


    public static void DrawBorder(WebElement element) {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
    }


    /************************************** BROKEN LINKS **********************************************/

    public static void BrokenLinks(List<WebElement> FinalList) {
        try {
            for (int j = 0; j < FinalList.size(); j++) {

                HttpURLConnection connection = (HttpURLConnection) new URL(FinalList.get(j).getAttribute("href")).openConnection();
                connection.setConnectTimeout(3000);
                connection.connect();
                String Response = connection.getResponseMessage();
                //connection.disconnect();

                System.out.println(FinalList.get(j).getAttribute("href") + "---->" + Response);

            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }


    /**
     * Take screenshot of the screena and save in provided directory
     * @param FileName Name of the screenshot
     * @throws IOException If the file is not found
     */
    public static void TakeScreenshot(String FileName) throws IOException {
        // Take screenshot and store it as a file format
        File File = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);

        // copy screenshot to desired location using CopyFile method
        FileUtils.copyFile(File, new File("/Users/praveensharma/Desktop/Screenshot/" + FileName + ".jpeg"));
    }



    /**
     * Wait for the element to be visible
     * @param element The web element
     * @param TimeInSeconds Time for the driver to wait
     */
    public static void waitTillElementIsVisible(WebElement element, int TimeInSeconds)
    {
        wait = new WebDriverWait(BaseClass.getDriver(), TimeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Wait for the element to be visible
     * @param by The by locator of element
     * @param TimeInSeconds Time for the driver to wait
     */
    public static void waitTillElementIsVisible(By by, int TimeInSeconds)
    {
        wait = new WebDriverWait(BaseClass.getDriver(), TimeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    /**
     * Wait for the elemnt to be clickable and visible
     * @param element The Web element
     */
    public static void waitTillElementIsClickable(WebElement element) {
        wait = new WebDriverWait(BaseClass.getDriver(), FrameworkConstants.EXPLICITWAIT_CLICKABLE_TIME);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(element),
                ExpectedConditions.visibilityOf(element)));    }

    /**
     * Wait for the elemnt to be clickable and visible
     * @param by The by locator of the element
     */
    public static void waitTillElementIsClickable(By by) {
        wait = new WebDriverWait(BaseClass.getDriver(), FrameworkConstants.EXPLICITWAIT_CLICKABLE_TIME);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(by),
                ExpectedConditions.visibilityOfElementLocated(by)));
    }

    /*************************************** Wait TILL ELEMENT IS INVISIBLE ********************************************/

    public static void WaitTillElementIsInvisible(WebElement element)
    {
        wait = new WebDriverWait(BaseClass.getDriver(), 60 );
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void WaitTillElementIsInvisible(By by)
    {
        wait = new WebDriverWait(BaseClass.getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /********************** STALE ELEMENT EXCEPTION **************************/

    public static void WaitForStaleElement(WebElement element) {
        wait = new WebDriverWait(BaseClass.getDriver(), 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
    }


    /********************** WAIT FOR PRESENCE OF ELEMENT **************************/

    public static void WaitForPesenceOfElement(By by) {
        wait = new WebDriverWait(BaseClass.getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }



    /********************** ZOOM WEB PAGE **************************/

    public static void WebpageZoom(int ZoomPercent) {
        js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("document.body.style.zoom='" + ZoomPercent + "'");
    }

    /********************** SELECT FROM DROPDOWN BY TEXT **************************/

    public static void SelectFromDropdownByText(WebElement element, String SearchText) {
        select = new Select(element);
        select.selectByVisibleText(SearchText);
    }

    /********************** SELECT FROM DROPDOWN BY INDEX **************************/

    public static void SelectFromDropdownByIndex(WebElement element, int Index) {
        select = new Select(element);
        select.selectByIndex(Index);
    }

    /********************** SELECT FROM DROPDOWN BY VALUE **************************/

    public static void SelectFromDropdownByValue(WebElement element, String Value) {
        select = new Select(element);
        select.selectByValue(Value);
    }

    /********************** CHANGE ATTRIBUTE **************************/

    public static void SetAttribute(WebElement element, String AttributeName, String NewAttributeValue) {
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("arguments[0].setAttribute('" + AttributeName + "', '" + NewAttributeValue + "')", element);

    }

    /********************** SEND EMAIL **************************/

    /**
     * Email code can be found here: https://commons.apache.org/proper/commons-email/userguide.html
     * To receive email, go to your gmail security option and toggle on "Allow less secure apps"
     */
    public static void SendEmail(String EmailId, String Password)
    {


//        Email email = new SimpleEmail();
//        email.setHostName("smtp.gmail.com");
//        email.setSmtpPort(465);
//        email.setAuthenticator(new DefaultAuthenticator("rajatshandilyajenkins@gmail.com", "Bl00dyshits"));
//        email.setSSLOnConnect(true);
//        email.setFrom("rajatcontact9@gmail.com");
//        email.setSubject("Test Mail");
//        email.setMsg("This is a selenium automation test mail :-)");
//        email.addTo("rajatcontact9@gmail.com");
//        email.send();

//        // Create the attachment
//        EmailAttachment attachment = new EmailAttachment();
//        attachment.setPath("/Users/praveensharma/IdeaProjects/Teamerge_Panel/Extent_Reports/index.html");
//        attachment.setDisposition(EmailAttachment.ATTACHMENT);
//        attachment.setDescription("Please find Teamerge Panel Automation Report attached below. \n Do not reply on this email.");
//        attachment.setName("Rajat");
//
//        // Create the email message
//        MultiPartEmail email = new MultiPartEmail();
//
//        email.setHostName("smtp.gmail.com");
//        email.setSmtpPort(465);
//        email.setAuthenticator(new DefaultAuthenticator(EmailId, Password));
//        email.setSSLOnConnect(true);
//        email.addTo("rajatshandilya25@gmail.com", "Rajat Shandilya");
//        email.setFrom("rajatshandilyajenkins@gmail.com", "Rajat Shandilya");
//        email.setSubject("Teamerge Panel Automation Report");
//
//        // add the attachment
//        email.attach(attachment);
//
//        // send the email
//        email.send();

    }
}
