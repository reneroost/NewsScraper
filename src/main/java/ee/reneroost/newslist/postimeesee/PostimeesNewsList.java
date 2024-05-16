package ee.reneroost.newslist.postimeesee;

import ee.reneroost.Util;
import ee.reneroost.model.NewsArticle;
import ee.reneroost.newslist.delfiee.DelfiArticleExtraction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class PostimeesNewsList {

    public static final String POSTIMEES_URL = "https://www.postimees.ee";

    public static List<NewsArticle> getNewsList() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(POSTIMEES_URL);

        PostimeesCookiesRejection.rejectCookies(chromeDriver);
        clickTopNewsTab(chromeDriver);

        List<WebElement> newsList = getNewsWebElements(chromeDriver);
        return extractNewsArticlesFromWebElements(newsList);
    }

    private static void clickTopNewsTab(WebDriver webDriver) {
        List<WebElement> tabs = webDriver.findElements(By.className("tab-menu__title-container"));
        Actions actions = new Actions(webDriver);
        scrollIntoView(webDriver, tabs.get(1));
        Util.pauseSec(1);
        actions.moveToElement(tabs.get(1)).click().perform();
    }

    private static void scrollIntoView(WebDriver webDriver, WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        Util.pauseSec(1);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0, -500)", "");
    }

    public static List<WebElement> getNewsWebElements(WebDriver webDriver) {
        Util.pauseSec(1);
        WebElement articles = webDriver.findElement(By.xpath("//*[@data-index='1']"));
        return articles.findElements(By.tagName("article"));
    }

    public static List<NewsArticle> extractNewsArticlesFromWebElements(List<WebElement> newsList) {
        List<NewsArticle> newsArticles = new ArrayList<>();
        int rank = 1;
        for (WebElement news: newsList) {
            newsArticles.add(PostimeesArticleExtraction.extractNewsArticleFromWebElement(news, rank));
            rank++;
        }
        return newsArticles;
    }
}
