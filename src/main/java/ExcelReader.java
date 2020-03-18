/*
18.03.2020
created by yalind
*/

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ExcelReader {

    /**
     * returns an arrayList for every row in the file     *
     * @param file to be read.
     */
    /* returns an arrayList for every row in the file*/
    public ArrayList<ArrayList<String>> getRows(File file) {
        ArrayList<ArrayList<String>> fileRows = new ArrayList<>();

        try {
            // Create a workbook for excel file
            Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
            // get the sheet at index 0
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                ArrayList<String> rowParts = new ArrayList<>();
                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    rowParts.add(cellValue);
                }
                fileRows.add(rowParts);
            }

            workbook.close();
            return fileRows;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
