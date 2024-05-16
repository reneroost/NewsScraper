package ee.reneroost.newslist.delfiee;

import ee.reneroost.model.NewsArticle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DelfiArticleExtraction {

    public static NewsArticle extractNewsArticleFromWebElement(WebElement newsWebElement) {
        return new NewsArticle(
                extractTitleFromWebElement(newsWebElement),
                extractURLFromWebElement(newsWebElement),
                extractPublishingDateTimeFromWebElement(newsWebElement),
                extractScrapingDateTime(),
                extractRankDuringScraping(newsWebElement)
        );
    }

    private static String extractTitleFromWebElement(WebElement newsWebElement) {
        if (newsWebElement.getText().split("\\.")[0].equals("10")) {
            return newsWebElement.getText().substring(4);
        } else {
            return newsWebElement.getText().substring(3);
        }
    }

    private static String extractURLFromWebElement(WebElement newsWebElement) {
        return newsWebElement.findElement(By.tagName("a")).getAttribute("href");
    }

    private static LocalDateTime extractPublishingDateTimeFromWebElement(WebElement newsWebElement) {
        Elements publishingDate;
        try {
            Document doc = Jsoup.connect(extractURLFromWebElement(newsWebElement)).get();
            publishingDate = doc.getElementsByClass("article-info__publish-date");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        return LocalDateTime.parse(publishingDate.text(), formatter);
    }

    private static LocalDateTime extractScrapingDateTime() {
        return LocalDateTime.now();
    }

    private static int extractRankDuringScraping(WebElement newsWebElement) {
        String rankString = newsWebElement.getText().split("\\.")[0];
        return Integer.parseInt(rankString);
    }

}
