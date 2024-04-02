package ee.reneroost.delfiee;

import ee.reneroost.NewsArticle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static ee.reneroost.Util.pauseSec;

public class DelfiNewsList {

    public static final String DELFI_URL = "https://www.delfi.ee";

    public static List<NewsArticle> getNewsList() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(DELFI_URL);
        DelfiCookiesReject.rejectCookies(chromeDriver);

        clickTopNews(chromeDriver);

        List<WebElement> newsList = chromeDriver.findElements(By.className("headline-title-list__item"));
        return extractNewsArticlesFromWebElements(newsList);
    }

    private static void clickTopNews(WebDriver webDriver) {
        List<WebElement> tabs = webDriver.findElements(By.className("tabs__list-item"));
        Actions actions = new Actions(webDriver);
        scrollIntoView(webDriver, tabs.get(1));
        actions.moveToElement(tabs.get(1)).click().perform();
    }

    private static void scrollIntoView(WebDriver webDriver, WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,-500)", "");
    }

    private static List<NewsArticle> extractNewsArticlesFromWebElements(List<WebElement> newsList) {
        List<NewsArticle> newsArticles = new ArrayList<>();
        for (WebElement news: newsList) {
            newsArticles.add(extractArticleFromElement(news));
        }
        return newsArticles;
    }

    private static NewsArticle extractArticleFromElement(WebElement newsElement) {
        System.out.println(newsElement.getText());
        WebElement address = newsElement.findElement(By.tagName("a"));
        System.out.println(address.getAttribute("href"));
        return new NewsArticle(newsElement.getText(), address.getAttribute("href"));
    }


}
