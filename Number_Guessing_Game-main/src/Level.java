import java.util.Arrays;
import java.util.Optional;

public enum Level {
    Easy("1","Easy", 10),
    Medium("2", "Medium", 5),
    Hard("3", "Hard", 3);

    private final String id;
    private final String name;
    private final Integer chances;

    Level(String id, String name, Integer chances) {
        this.id = id;
        this.name = name;
        this.chances = chances;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getChances() {
        return chances;
    }

    public static Optional<Level> getLevelById(String id){
        return Arrays.stream(Level.values())
                .filter(level -> level.getId().equals(id.trim()))
                .findFirst();
    }

    @Override
    public String toString() {
        return "Level{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chances=" + chances +
                '}';
    }
}
