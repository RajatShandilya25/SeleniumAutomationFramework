package RetryUtility;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This calls will be called only once ie... beforeSuite
 *
 * MethodInterceptor changes the "tests to run" and their attributes at runtime. It is used to
 * decide which tests to run at runtime.
 */
public class MethodInterceptor implements IMethodInterceptor
{


    /**
     * List<IMethodInstance> contains the list of all the tests that testNG will execute in
     * in insertion order
     *
     * Source: https://www.youtube.com/watch?v=TZq64ez7Iqo&list=PL9ok7C7Yn9A_JZFMrhrgEwfqQGiuyvSkB&index=22
     *
     * @param methods : contains @tests names from all classed
     * @param context:
     * @return list of modified tests
     */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context)
    {
        /*
        Instead of hampering original List<IMethodInstance> list, we'll create another list
        and add methods to it.
        methods.get(0): adding first test to the new list
         */
        List<IMethodInstance> resultList = new ArrayList<IMethodInstance>();

        Map<String, String> testMap1 = new HashMap<>();
        testMap1.put("name", "validateTest");
        testMap1.put("count", "2");

        Map<String, String> testMap2 = new HashMap<>();
        testMap2.put("name", "validateHomePageTitle1");
        testMap2.put("count", "2");

        //Add maps in the list
        List<Map<String, String>> testsList = new ArrayList<>();
        testsList.add(testMap1);
        testsList.add(testMap2);

        //Compare if name from method list is equal to the name from the final list
        for(int i=0; i<methods.size(); i++)
        {
            for(int j=0; j<testsList.size(); j++)
            {
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(testsList.get(j).get("name")))
                {
                    methods.get(i).getMethod().setInvocationCount(Integer.parseInt(testsList.get(j).get("count")));
                    resultList.add(methods.get(i));
                }
            }
        }


        return resultList;
    }
}
