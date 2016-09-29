package org.darebeat.demo.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by darebeat on 9/29/16.
 */
public class HelloWorld {
    public static void main(String[] args) {

        try {
            // 1. create the document
            Document doc = new Document();

            // 2. get PdfWriter
            PdfWriter.getInstance(doc,new FileOutputStream("data/tmp/helloworld.pdf"));

            // 3. open the document
            doc.open();

            // 4. add the content
            doc.add(new Paragraph("Hello World!"));

            // 5. close the document
            doc.close();

            System.out.println("Document created!");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
