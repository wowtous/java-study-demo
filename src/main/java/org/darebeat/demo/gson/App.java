package org.darebeat.demo.gson;

import com.google.gson.Gson;
import org.darebeat.model.Article;
import org.darebeat.utils.InitData;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by darebeat on 9/29/16.
 */
public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<Article> articles = new LinkedList<Article>();

        articles.add(InitData.createArticle());
        articles.add(InitData.createArticle());

        // Java --> JSON
        String json = gson.toJson(articles);
        System.out.println("toJson: "+json);

        // JSON -> Java
        List list = gson.fromJson(json,List.class);
        System.out.println("fromJson: "+list);
        System.out.println("ClassType: "+list.get(0).getClass());
    }
}
