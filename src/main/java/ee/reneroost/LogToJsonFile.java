package ee.reneroost;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class LogToJsonFile {

    public static final String SCRAPED_NEWS_FOLDER = "/home/rene/Documents/ScrapedNews/";

    public static void loggingInJson(String newsSite, List<NewsArticle> newsArticles) {
        ObjectMapper objectMapper = new ObjectMapper();
        writeToFile(newsSite, "[");
        for (int i = 0; i < newsArticles.size(); i++) {
            NewsArticle newsArticle = newsArticles.get(i);
            try {
                String newsArticleString = objectMapper.writeValueAsString(newsArticle);
                if (i < newsArticles.size() - 1) {
                    writeToFile(newsSite, newsArticleString + ",");
                } else if (i == newsArticles.size() - 1) {
                    writeToFile(newsSite, newsArticleString + "]");
                }

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void writeToFile(String newsSite, String newsArticle) {
        String fileName = generateFileName(newsSite);
        String folderName = SCRAPED_NEWS_FOLDER + newsSite + "/";
        try (
                FileWriter fileWriter = new FileWriter(new File(folderName, fileName), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
        ) {
            printWriter.println(newsArticle);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateFileName(String newsSite) {
        return newsSite + "_" + LocalDate.now() + ".json";
    }
}
