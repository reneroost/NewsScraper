package ee.reneroost.model;

import java.time.LocalDateTime;

public class NewsArticle {

    private final String title;
    private final String url;
    private final LocalDateTime publishingDateTime;
    private final LocalDateTime scrapingDateTime;
    private final int rankingDuringScraping;

    public NewsArticle(String title, String url, LocalDateTime publishingDateTime, LocalDateTime scrapingDateTime, int rankingDuringScraping) {
        this.title = title;
        this.url = url;
        this.publishingDateTime = publishingDateTime;
        this.scrapingDateTime = scrapingDateTime;
        this.rankingDuringScraping = rankingDuringScraping;
    }

    @Override
    public String toString() {
        return "NewsArticle{" +
                "title='" + title + "'\n" +
                ", url='" + url + "'\n" +
                ", publishingDateTime=" + publishingDateTime +
                ", scrapingDateTime=" + scrapingDateTime +
                ", positionDuringScraping=" + rankingDuringScraping +
                "}\n";
    }
}
