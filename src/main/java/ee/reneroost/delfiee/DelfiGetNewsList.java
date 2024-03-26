package ee.reneroost.delfiee;

import ee.reneroost.NewsArticle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static ee.reneroost.General.pauseSec;

public class DelfiGetNewsList {

    public static List<NewsArticle> getNewsList() {
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://www.delfi.ee");
        DelfiCookiesReject.rejectCookies(chromeDriver, "PRIVAATSUSSÄTTED", "SALVESTA JA VÄLJU");


        List<WebElement> tabs = chromeDriver.findElements(By.className("tabs__list-item"));
        for (WebElement tab: tabs) {
            System.out.println("Tääb: " + tab.getText());
        }

        pauseSec(1);
        Actions actions = new Actions(chromeDriver);

        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", tabs.get(1));
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        js.executeScript("window.scrollBy(0,-500)", "");
        pauseSec(1);

        actions.moveToElement(tabs.get(1)).click().perform();

        pauseSec(1);
        WebElement activeTab2 = chromeDriver.findElement(By.className("tabs__list-item--active"));
        System.out.println("Praegu aktiivne: " + activeTab2.getText());

        List<WebElement> newsList = chromeDriver.findElements(By.className("headline-title-list__item"));

        List<NewsArticle> newsArticles = new ArrayList<>();
        for (WebElement news: newsList) {
            System.out.println(news.getText());
            WebElement address = news.findElement(By.tagName("a"));
            System.out.println(address.getAttribute("href"));
            NewsArticle newsArticle = new NewsArticle(news.getText(), address.getAttribute("href"));
            newsArticles.add(newsArticle);
        }
        return newsArticles;
    }
}
