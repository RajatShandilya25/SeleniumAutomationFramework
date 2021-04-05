package RetryUtility;

import Utility.ReadPropertyFile;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

public final class RetryRunner implements IRetryAnalyzer
{

    int count = 0;
    int RetryCount = 2;

    @Override
    public boolean retry(ITestResult result)
    {

            if(ReadPropertyFile.readPropertyFile("DoRetry").equalsIgnoreCase("True")
                    && count < RetryCount)
            {
                count++;
                System.out.println("** Retrying " +result.getName() +" "+(count) +" **");
                return true;
            }
        return false;
    }
}
