package hextechlibrary.dto.tft;

public abstract class Item {
    int id;
    String name;
    String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
