package ee.reneroost;

import ee.reneroost.delfiee.DelfiNewsList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<NewsArticle> newsArticles = DelfiNewsList.getNewsList();
        for (NewsArticle newsArticle: newsArticles) {
            System.out.println(newsArticle);
        }

        LogToJsonFile.loggingInJson("Delfi", newsArticles);


    }
}