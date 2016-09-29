package org.darebeat.utils;

import org.darebeat.model.Article;

/**
 * Created by darebeat on 9/29/16.
 */
public class InitData {
    public static Article createArticle(){
        Article article = new Article();

        article.setTitle("Castor - Java Object to XML & XML to Object Mapping");
        article.setUrl("http://hmkcode.com/castor-java-object-xml");
        article.addCategory("Java");
        article.addTag("Java");
        article.addTag("Castor");
        article.addTag("XML");
        article.addTag("Marshalling");
        article.addTag("Unmarshalling");

        return article;
    }
}
