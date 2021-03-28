package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class DataProviderUtility_RunMAnager
{
    private DataProviderUtility_RunMAnager() {}

    /**
     * This utility reads test case name and other properties from the excel file,
     * store it in a map, and add it to a list.
     * A single map contains only info about 1 test case
     *
     * Source: https://www.youtube.com/watch?v=bHEHMNaaIoc&list=PL9ok7C7Yn9A_JZFMrhrgEwfqQGiuyvSkB&index=25
     * @return a list of hash maps.
     * @throws IOException when file is not found.
     */
    public static List<Map<String, String>>  getRunManagerData(String SheetName) throws IOException
    {
        FileInputStream fis = new FileInputStream(FrameworkConstants.EXCEL_FILE_PATH);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(SheetName);

        Map<String, String> dataMap = null;
        List<Map<String, String>> dataList =  new LinkedList<>();

        int lastRow = sheet.getLastRowNum();
        int lastColumn = sheet.getRow(0).getLastCellNum();

        for(int i=1; i<=lastRow; i++)
        {
            dataMap = new HashMap<>();
            for(int j=0; j<lastColumn; j++)
            {
                dataMap.put(sheet.getRow(0).getCell(j).getStringCellValue().trim(),
                        sheet.getRow(i).getCell(j).getStringCellValue().trim()); //Put data in a map
            }
            dataList.add(dataMap); // Adds map to list
        }

        return dataList;
    }



}
