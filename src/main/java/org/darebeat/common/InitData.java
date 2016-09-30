package org.darebeat.common;

import org.darebeat.model.Article;

/**
 * Created by darebeat on 9/29/16.
 */
public class InitData {
    public static Article createArticle(){
        Article article = new Article();

        article.setTitle("Java Object2XML & XML2Object Mapping");
        article.setUrl("https://github.com/wowtous/java-study-demo.git");
        article.addCategory("Java");
        article.addTag("Java");
        article.addTag("JSON");
        article.addTag("XML");
        article.addTag("Marshalling");
        article.addTag("Unmarshalling");

        return article;
    }
}
