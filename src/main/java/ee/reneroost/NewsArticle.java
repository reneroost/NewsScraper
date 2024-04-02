package ee.reneroost;

import java.time.LocalDateTime;

public class NewsArticle {

    private String title;
    private String url;
    private LocalDateTime publishingDateTime;
    private LocalDateTime scrapingDateTime;
    private int positionDuringScraping;

    public NewsArticle(String title, String url, LocalDateTime publishingDateTime, LocalDateTime scrapingdateTime, int positionDuringScraping) {
        this.title = title;
        this.url = url;
        this.publishingDateTime = publishingDateTime;
        this.scrapingDateTime = scrapingdateTime;
        this.positionDuringScraping = positionDuringScraping;
    }

    public NewsArticle(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getPublishingDateTime() {
        return publishingDateTime;
    }

    public void setPublishingDateTime(LocalDateTime publishingDateTime) {
        this.publishingDateTime = publishingDateTime;
    }

    public LocalDateTime getScrapingDateTime() {
        return scrapingDateTime;
    }

    public void setScrapingDateTime(LocalDateTime scrapingDateTime) {
        this.scrapingDateTime = scrapingDateTime;
    }

    public int getPositionDuringScraping() {
        return positionDuringScraping;
    }

    public void setPositionDuringScraping(int positionDuringScraping) {
        this.positionDuringScraping = positionDuringScraping;
    }

    @Override
    public String toString() {
        return "NewsArticle{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
