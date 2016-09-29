package org.darebeat.demo.html_pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by darebeat on 9/29/16.
 */
public class Html2Pdf {
    public static void main(String[] args) {
        Document doc = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(doc,new FileOutputStream("data/tmp/Html2Pdf.pdf"));
            doc.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer,doc,new FileInputStream("data/html/index.html"));
            doc.close();

            System.out.println( "PDF Created!" );
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
