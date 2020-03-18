/*
18.03.2020
created by yalind
*/

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ExcelReaderTest {
    File file;
    ExcelReader excelReader;
    ArrayList<ArrayList<String>> rows;
    private final static String EXCEL_PATH = "/textexcel.xlsx";

    @Before
    public void init() {
        excelReader = new ExcelReader();
        file = new File(ExcelReaderTest.class.getResource("/testexcel.xlsx").getFile());
        rows = excelReader.getRows(file);
        //use this in src/main if below file init is now working
        //file = new File(ExcelReaderTest.class.getResource(EXCEL_PATH).getFile());
    }

    @Test
    public void ExcelFileLengthIsValid() {
        assertEquals(rows.size(), 9);
    }

    @Test
    public void ExcelFileContentIsValid() {
        assertEquals(rows.get(0).get(0), "a-2");
        assertEquals(rows.get(0).get(1), "b-2");
        assertEquals(rows.get(0).get(2), "c-2");

        assertEquals(rows.get(8).get(0), "a-10");
        assertEquals(rows.get(8).get(1), "b-10");
        assertEquals(rows.get(8).get(2), "c-10");
    }
}
