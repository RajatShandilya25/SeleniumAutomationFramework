package RetryUtility;

import Utility.DataProviderUtility_RunMAnager;
import Utility.FrameworkConstants;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will be executed before every method
 *
 */
public final class AnnotationTransformer implements IAnnotationTransformer
{

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {

        //Add maps in the list
        List<Map<String, String>> testsList = DataProviderUtility_RunMAnager.getRunManagerData(FrameworkConstants.RUNMANAGER_SHEET);

//        testsList.add(testMap1);
//        testsList.add(testMap2);


        for(int i=0; i<testsList.size(); i++)
        {
            if(testMethod.getName().equalsIgnoreCase(String.valueOf(testsList.get(i).get("name"))))
            {
                if(testsList.get(i).get("Execute").equalsIgnoreCase("No"))
                {
                    annotation.setEnabled(false);
                }
            }
            else
            {
                annotation.setRetryAnalyzer(RetryRunner.class);
            }
        }


        //If test fails, do retry
    }
}
