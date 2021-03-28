package RetryUtility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class Listeners implements ITestListener, ISuiteListener
{
    @Override
    public void onStart(ISuite suite)
    {
        System.out.println("inside 1");
    }

    @Override
    public void onFinish(ISuite suite)
    {
        System.out.println("inside 2");
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("inside 3");
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("inside 4");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("inside 5");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("inside 6");
    }

    @Override
    public void onStart(ITestContext context)
    {
    }

    @Override
    public void onFinish(ITestContext context)
    {
    }
}
