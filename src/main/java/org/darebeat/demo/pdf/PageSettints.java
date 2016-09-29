package org.darebeat.demo.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by darebeat on 9/29/16.
 */
public class PageSettints {
    public static void main(String[] args) {
        try {
            // 1. create the document page size: A4, margins: left:20 right:20 top:40 bottom:40
            Document doc = new Document(PageSize.A4,20f,20f,40f,40f);

            //for custom pagesize
            //Rectangle pagesize = new Rectangle(216f, 720f);

            // 2. get PdfWriter
            PdfWriter.getInstance(doc,new FileOutputStream("data/tmp/pagesettings.pdf"));

            // 3. open the document
            doc.open();

            // 4. add the content
            doc.add(new Paragraph("Hello World!"));

            // 5. close the document
            doc.close();

            System.out.println("Document created!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
