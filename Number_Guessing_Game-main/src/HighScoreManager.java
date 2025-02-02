import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class HighScoreManager {
    private static final String FILE_PATH = "highscores.dat";
    private static final Map<String, Integer> highScores = new ConcurrentHashMap<>();

    public static void loadHighScores(){
        Properties properties = new Properties();
        Path filePath = Paths.get(FILE_PATH);
        if (!Files.exists(filePath)){
            return;
        }

        try {
            properties.load(Files.newInputStream(filePath));
            properties.forEach((key, value)-> highScores.put((String) key, Integer.parseInt((String) value)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load high scores, starting with empty scores.", e);
        }
    }

    public static void saveHighScores(){
        Properties properties = new Properties();
        highScores.forEach((key, value)-> properties.setProperty(key, value.toString()));

        try {
            properties.store(Files.newOutputStream(Paths.get(FILE_PATH)), "High Scores");
        } catch (IOException e) {
            throw new RuntimeException("Failed to save high scores.", e);
        }
    }

    public static void updateHighScores(String level, int attempts){
        Integer currentHighScore = highScores.get(level);
        if (currentHighScore == null || attempts < currentHighScore){
            highScores.put(level, attempts);
            System.out.println("\nNew high score for " + level + "level: " + attempts + " attempts!");
            saveHighScores();
        }
    }

}
