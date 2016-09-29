package org.darebeat.demo.xml;

import org.darebeat.model.Article;
import org.darebeat.utils.InitData;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by darebeat on 9/29/16.
 */
public class App {
    public static void main(String[] args) {
        try {

            //( 1 ) OBJECT --> XML
            FileWriter writer = new FileWriter("data/article.xml");
            Marshaller.marshal(InitData.createArticle(), writer);
            writer.close();


            //( 2 ) XML --> OBJECT
            FileReader reader = new FileReader("data/article.xml");
            Article article = (Article) Unmarshaller.unmarshal(Article.class, reader);

            System.out.println(article);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (MarshalException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}
