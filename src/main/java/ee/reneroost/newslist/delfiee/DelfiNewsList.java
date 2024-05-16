package ee.reneroost.newslist.delfiee;

import ee.reneroost.model.NewsArticle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class DelfiNewsList {

    public static final String DELFI_URL = "https://www.delfi.ee";

    public static List<NewsArticle> getNewsList() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(DELFI_URL);

        DelfiCookiesRejection.rejectCookies(chromeDriver);
        clickTopNewsTab(chromeDriver);

        List<WebElement> newsList = chromeDriver.findElements(By.className("headline-title-list__item"));
        return extractNewsArticlesFromWebElements(newsList);
    }

    private static void clickTopNewsTab(WebDriver webDriver) {
        List<WebElement> tabs = webDriver.findElements(By.className("tabs__list-item"));
        Actions actions = new Actions(webDriver);
        scrollIntoView(webDriver, tabs.get(1));     // Second tab (index 1) is top news tab
        actions.moveToElement(tabs.get(1)).click().perform();
    }

    private static void scrollIntoView(WebDriver webDriver, WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;             // there is a possible overlay,
        js.executeScript("window.scrollBy(0,-500)", "");       // need to scroll a bit further
    }

    public static List<NewsArticle> extractNewsArticlesFromWebElements(List<WebElement> newsList) {
        List<NewsArticle> newsArticles = new ArrayList<>();
        for (WebElement news: newsList) {
            newsArticles.add(DelfiArticleExtraction.extractNewsArticleFromWebElement(news));
        }
        return newsArticles;
    }


}
