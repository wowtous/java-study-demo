package org.darebeat.demo.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by darebeat on 9/29/16.
 */
public class AppRead {
    public static void main(String[] args) {

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File("data/tmp/workbook.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheetAt(0);

        Cell cell = sheet.getRow(0).getCell(0);
        double numberVal = cell.getNumericCellValue();
        System.out.println("Row 0 Column 0 => " + numberVal);

        cell = sheet.getRow(0).getCell(1);
        String stringVal = cell.getStringCellValue();
        System.out.println("Row 0 Column 1 => " + stringVal);

        cell = sheet.getRow(0).getCell(2);
        Date dateVal = cell.getDateCellValue();
        System.out.println("Row 0 Column 2 => " + dateVal);

        cell = sheet.getRow(0).getCell(3);
        boolean boolVal = cell.getBooleanCellValue();
        System.out.println("Row 0 Column 3 => " + boolVal);
    }
}
