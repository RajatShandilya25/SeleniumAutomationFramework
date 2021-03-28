package RetryUtility;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

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
        Map<String, Object> testMap1 = new HashMap<>();
//        testMap1.put("name", "validateTest");
        testMap1.put("name", "validateTest");
        testMap1.put("count", "2");
        testMap1.put("Enabled", true);

        Map<String, Object> testMap2 = new HashMap<>();
        testMap2.put("name", "validateHomePageTitle");
        testMap2.put("count", "2");
        testMap2.put("Enabled", false);


        //Add maps in the list
        List<Map<String, Object>> testsList = new ArrayList<>();
        testsList.add(testMap1);
        testsList.add(testMap2);


        for(int i=0; i<testsList.size(); i++)
        {
            if(testMethod.getName().equalsIgnoreCase(String.valueOf(testsList.get(i).get("name"))))
            {
                if(testsList.get(i).get("Enabled").equals(false))
                {
                    annotation.setEnabled(false);
                }
            }
            else
            {
                annotation.setInvocationCount(Integer.parseInt((String)testsList.get(i).get("count")));
                annotation.setRetryAnalyzer(RetryRunner.class);
            }
        }


        //If test fails, do retry
    }
}
