package org.darebeat.demo.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by darebeat on 9/29/16.
 */
public class AppWrite {
    public static void main(String[] args) {
        String filepath = "data/tmp/workbook.xlsx";

        // 1. Create a new Workbook
        Workbook workbook = new XSSFWorkbook();

        // 2. Create a new sheet
        Sheet sheet = workbook.createSheet("sheet 1");

        // 3. Create a row
        Row row = sheet.createRow(0);

        // 4. Create cells
        //  4.1 number cell
        row.createCell(0).setCellValue(1);

        //  4.2 text
        row.createCell(1).setCellValue("Text");

        //  4.3 date cell
        CreationHelper creationHelper = workbook.getCreationHelper();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        Cell cell = row.createCell(2);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);

        //  4.4 boolean cell
        row.createCell(3).setCellValue(true);

        // 5. create excel file
        FileOutputStream out;

        try {
            out = new FileOutputStream(filepath);
            workbook.write(out);
            out.close();

            System.out.println( "File created!" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
