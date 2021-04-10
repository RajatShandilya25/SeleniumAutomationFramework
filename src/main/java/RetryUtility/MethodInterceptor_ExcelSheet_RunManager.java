package RetryUtility;

import Utility.DataProviderUtility_RunMAnager;
import Utility.FrameworkConstants;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MethodInterceptor_ExcelSheet_RunManager implements IMethodInterceptor
{


    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context)
    {
        List<IMethodInstance> finalTestsList = null;
        
        try
        {
            List<Map<String, String>> dataList = DataProviderUtility_RunMAnager.getRunManagerData(FrameworkConstants.RUNMANAGER_SHEET);
            finalTestsList = new ArrayList<>();

            //Compare if name from method list is equal to the name from the finalTestsList
            for(int i=0; i<methods.size(); i++)
            {
                for(int j=0; j<dataList.size(); j++)
                {
                    if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(dataList.get(j).get("TestCaseName")))
                    {
                        if(dataList.get(j).get("Execute").equalsIgnoreCase("Yes"))
                        {
//                            methods.get(i).getMethod().setInvocationCount(Integer.parseInt(dataList.get(j).get("count")));
                            finalTestsList.add(methods.get(i));
                        }
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return finalTestsList;
    }
}
