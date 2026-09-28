
package seleniumautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    public static Object[][] getTestData(
            String filePath,
            String sheetName) throws IOException {

        FileInputStream file = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][columns];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rows; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < columns; j++) {

                data[i - 1][j] =
                        formatter.formatCellValue(row.getCell(j));
            }
        }

        workbook.close();
        file.close();

        return data;
    }
}

