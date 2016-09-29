package org.darebeat.demo.pdf_table;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by darebeat on 9/29/16.
 */
public class App {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.setPageSize(PageSize.A4);

        try {
            PdfWriter writer = PdfWriter.getInstance(doc,new FileOutputStream("data/pdf_table.pdf"));
            doc.open();
            doc.add(TableBuilder.createTable());
            doc.close();
            System.out.println( "PDF Created!" );
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
