package org.darebeat.demo.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.darebeat.model.Article;
import org.darebeat.utils.InitData;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by darebeat on 9/29/16.
 */
public class App {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String filepath = "data/tmp/article.json";

        try {
            // POJO => JSON
            mapper.writeValue(new File(filepath), InitData.createArticle());
            System.out.println("json created!");

            //JSON to POJO
            Article article = mapper.readValue(new File(filepath),Article.class);
            System.out.println(article);

            // Raw Data Binding Example
            Map<String,Object> map = mapper.readValue(new File(filepath),Map.class);
            System.out.println(map);

            // Data binding Collection<E>
            List<Article> articles = new LinkedList<Article>();
            articles.add(InitData.createArticle());
            articles.add(InitData.createArticle());

            mapper.writeValue(new File(filepath),articles);

            // Collection Map
            List result = mapper.readValue(new File(filepath),List.class);
            System.out.println(result.get(0).getClass());
            System.out.println(result);

            // Collection Article
            result = mapper.readValue(new File(filepath), new TypeReference<List<Article>>() {});
            System.out.println(result.get(0).getClass());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
