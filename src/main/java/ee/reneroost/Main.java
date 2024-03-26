package ee.reneroost;

import ee.reneroost.delfiee.DelfiGetNewsList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;

import static ee.reneroost.General.pauseSec;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<NewsArticle> newsArticles = DelfiGetNewsList.getNewsList();


    }
}