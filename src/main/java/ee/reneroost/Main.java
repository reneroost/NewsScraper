package ee.reneroost;

import ee.reneroost.model.NewsArticle;
import ee.reneroost.newslist.delfiee.DelfiNewsList;
import ee.reneroost.newslist.postimeesee.PostimeesNewsList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<NewsArticle> newsArticlesPostimees = PostimeesNewsList.getNewsList();
        List<NewsArticle> newsArticlesDelfi = DelfiNewsList.getNewsList();

//        LoggingToJson.logToJsonFile("Delfi", newsArticlesDelfi);

    }
}