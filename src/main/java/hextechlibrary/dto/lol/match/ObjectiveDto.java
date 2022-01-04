package hextechlibrary.dto.lol.match;

//TODO: Convert to Builder Pattern
public class ObjectiveDto {
    protected boolean first;
    protected int kills;

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
}
