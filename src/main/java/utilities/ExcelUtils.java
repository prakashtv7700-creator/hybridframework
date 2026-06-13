package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static final String FILE_PATH =
            System.getProperty("user.dir")
            + "/src/main/resources/TestData/LoginData.xlsx";

    public static String getTestData(String testCaseName,
                                     String columnName) {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet("LoginData");

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet 'LoginData' not found.");
            }

            // Get header row
            Row headerRow = sheet.getRow(0);
            int columnIndex = -1;
            // Find the requested column
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String header = headerRow.getCell(i)
                                 .getStringCellValue()
                                 .trim();

                if (header.equalsIgnoreCase(columnName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex == -1) {
                throw new RuntimeException(
                        "Column not found: " + columnName);
            }

            // Find the testcase row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                String currentTestCase =
                        row.getCell(0)
                           .getStringCellValue()
                           .trim();

                if (currentTestCase.equalsIgnoreCase(testCaseName)) {
                    Cell cell = row.getCell(columnIndex);
                    if (cell == null) {
                        return "";
                    }

                    return cell.toString().trim();
                }
            }

            throw new RuntimeException(
                    "Test case not found: " + testCaseName);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to read Excel data: "
                    + e.getMessage(), e);
        }
    }
}

























































































