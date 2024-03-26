package ee.reneroost;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class LogsInJsonFile {


    public static void loggingInJson(NewsArticle newsArticle, File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File());
    }
}
