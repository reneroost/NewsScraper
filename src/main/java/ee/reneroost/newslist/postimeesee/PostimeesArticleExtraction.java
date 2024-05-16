package ee.reneroost.newslist.postimeesee;

import ee.reneroost.model.NewsArticle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostimeesArticleExtraction {

    public static NewsArticle extractNewsArticleFromWebElement(WebElement newsWebElement, int rank) {
        return new NewsArticle(
                extractTitleFromWebElement(newsWebElement),
                extractURLFromWebElement(newsWebElement),
                extractPublishingDateTimeFromWebElement(newsWebElement),
                extractScrapingDateTime(newsWebElement),
                rank
        );
    }

    private static String extractTitleFromWebElement(WebElement newsWebElement) {
        String titleWithDateTimeAndCommentCount = newsWebElement.getText();     // gets whole title
        String titleWithCommentCount = titleWithDateTimeAndCommentCount.split("\\n")[1];    // removes DateTime
        int commentsStartIndex = titleWithCommentCount.lastIndexOf(' ');    // finds where CommentCount starts
        return titleWithCommentCount.substring(0, commentsStartIndex);          // removes CommentCount
    }

    private static String extractURLFromWebElement(WebElement newsWebElement) {
        return newsWebElement.findElement(By.tagName("a")).getAttribute("href");
    }

    private static LocalDateTime extractPublishingDateTimeFromWebElement(WebElement newsWebElement) {
        String publishingDateWithTimeZone = newsWebElement.findElement(By.tagName("meta")).getAttribute("content");
        String publishingDate = publishingDateWithTimeZone.substring(0, 19);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.parse(publishingDate, formatter);
    }

    private static LocalDateTime extractScrapingDateTime(WebElement newsWebElement) {
        return LocalDateTime.now();
    }

}
