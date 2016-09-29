package org.darebeat.demo.xml;

import org.darebeat.model.Article;
import org.darebeat.utils.InitData;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.*;

import java.io.*;

/**
 * Created by darebeat on 9/29/16.
 */
public class AppMapping {
    public static void main(String[] args) {
        String filepath = "data/tmp/mapped_article.xml";

        try {
            //Load Mapping
            Mapping mapping = new Mapping();
            mapping.loadMapping("data/mapping.xml");
            XMLContext context = new XMLContext();
            context.addMapping(mapping);

            //( 1 ) OBJECT --> XML

            //1.1 Prepare file writer
            Writer writer = new FileWriter(filepath);

            //1.2 Create a new Marshaller
            Marshaller marshaller = context.createMarshaller();
            marshaller.setWriter(writer);

            //1.3 Marshal "map" to xml
            marshaller.marshal(InitData.createArticle());

            //1.4
            writer.close();


            //( 2 ) XML --> OBJECT

            //2.1 Prepare file writer
            Reader reader = new FileReader(filepath);

            //2.2 Create a new Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setClass(Article.class);

            //2.3 Unmarshal "map" to Object
            Article article = (Article) unmarshaller.unmarshal(reader);

            //2.4
            reader.close();

            System.out.println(article);

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (MappingException e1) {
            e1.printStackTrace();
        } catch (MarshalException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}
