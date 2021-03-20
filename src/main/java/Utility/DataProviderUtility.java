package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataProviderUtility
{

    @Test(dataProvider = "getData1")
    public void validateTestData(Map<String, String> dataMap)
    {
        System.out.println(dataMap.get("Username") +" : " +dataMap.get("Password") +" : " +dataMap.get("Age")
         +" : " +dataMap.get("Gender"));
    }


    /**
     * First we give the file location using FileInputStream class
     * then find the workbook in the location using XSSFWorkbook class
     * then find the sheet in the excel file using XSSFWorkbook object which returns XSSFSheet class object
     * We have the sheet and file
     * - Now iterate through the file and save data in Object[] as LinkedHashMap
     * Source: https://www.youtube.com/watch?v=YB7gy911rHg&list=PL9ok7C7Yn9A_JZFMrhrgEwfqQGiuyvSkB&index=18
     *
     * sheet.getLastRowNum() -> last row number
     * sheet.getRow(0).getLastCellNum() -> last column cell number for the row as columns are
     * same for every row
     *
     * NOTE: Add " ' " as a prefix to integer value in excel sheet to read them as a string otherwise
     * we've to convert them to String explicitly
     *
     * @throws IOException if excel file is not found
     * @return object[]
     */
    @DataProvider
    public Object[] getData1() throws IOException
    {
        FileInputStream fis = new FileInputStream(FrameworkConstants.EXCEL_FILE_PATH);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("TestDataSheet");

        int rowCount = sheet.getLastRowNum();
//        System.out.println("-->" +rowCount);

        int columnCount = sheet.getRow(0).getLastCellNum();
//        System.out.println("-->" +columnCount);


        Object testData[] = new Object[rowCount];
        Map<String, String> dataMap;

        for(int i=1; i<=rowCount; i++)
        {
            dataMap = new LinkedHashMap<>();
            for(int j=0; j<columnCount; j++)
            {
                String  key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                dataMap.put(key, value);
                testData[i-1] = dataMap;
//                System.out.print(testData[i-1][j] +", ");
            }
        }

        return testData;
    }



    

    /**
     * First we give the file location using FileInputStream class
     * then find the workbook in the location using XSSFWorkbook class
     * then find the sheet in the excel file using XSSFWorkbook object which returns XSSFSheet class object
     * We have the sheet and file
     * - Now iterate through the file and save data in Object[number of rows][number of columns];
     *
     * sheet.getLastRowNum() -> last row number
     * sheet.getRow(0).getLastCellNum() -> last column cell number for the row as columns are
     * same for every row
     *
     * NOTE: Add " ' " as a prefix to integer value in excel sheet to read them as a string otherwise
     * we've to convert them to String explicitly
     *
     * @throws IOException if excel file is not found
     * @return object[][]
     */
//    @DataProvider
//    public Object[][] getData() throws IOException
//    {
//        FileInputStream fis = new FileInputStream(FrameworkConstants.EXCEL_FILE_PATH);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheet("TestDataSheet");
//
//        int rowCount = sheet.getLastRowNum();
//
//        int columnCount = sheet.getRow(0).getLastCellNum();
//
//
//        Object testData[][] = new Object[rowCount][columnCount];
//        for(int i=1; i<=rowCount; i++)
//        {
//            for(int j=0; j<columnCount; j++)
//            {
//                testData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
//            }
//        }
//
//        return testData;
//    }
}
