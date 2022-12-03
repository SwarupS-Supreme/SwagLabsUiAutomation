package Utils;

import Constants.SheetNames;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class DataRetriever {

    private DataRetriever() {

    }

    @DataProvider
    public static Object[] getData() {
        List<Map<String, String>> list = null;
        String sheetName = SheetNames.getLogincredentialsheetname();
        System.out.print("sheetname = "+sheetName);
        try (FileInputStream fis = new FileInputStream(ConstantFilePath.getExcelfilepath())) {
            Map<String, String> map = null;
            list = new ArrayList<>();
            XSSFWorkbook workbook;
            workbook = new XSSFWorkbook(fis);
            int totalRowCount = workbook.getSheet(sheetName).getLastRowNum();
            int totalCellCountEachRow = workbook.getSheet(sheetName).getRow(0).getLastCellNum();
            for (int i = 1; i < totalRowCount + 1; i++) {
                map = new HashMap<>();
                for (int j = 0; j < totalCellCountEachRow; j++) {
                    String key = workbook.getSheet(sheetName).getRow(0).getCell(j).toString();
                    String value = workbook.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(list).toArray();
    }
}
