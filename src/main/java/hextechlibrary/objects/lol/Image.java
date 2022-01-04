package hextechlibrary.objects.lol;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Image.Builder.class)
public class Image {
    private final String full;
    private final String sprite;
    private final String group;
    private final int x;
    private final int y;
    private final int w;
    private final int h;

    public Image(Builder builder) {
        this.full = builder.full;
        this.sprite = builder.sprite;
        this.group = builder.group;
        this.x = builder.x;
        this.y = builder.y;
        this.w = builder.w;
        this.h = builder.h;
    }

    public String getFull() {
        return full;
    }

    public String getSprite() {
        return sprite;
    }

    public String getGroup() {
        return group;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String full;
        private String sprite;
        private String group;
        private int x;
        private int y;
        private int w;
        private int h;

        public Builder withFUll(String full){
            this.full = full;
            return this;
        }
        public Builder withSprite(String sprite){
            this.sprite = sprite;
            return this;
        }
        public Builder withGroup(String group){
            this.group = group;
            return this;
        }
        public Builder withX(int x){
            this.x = x;
            return this;
        }
        public Builder withY(int y){
            this.y = y;
            return this;
        }
        public Builder withW(int w){
            this.w = w;
            return this;
        }
        public Builder withH(int h){
            this.h = h;
            return this;
        }

        public Image build(){
            Image image = new Image(this);
            //TODO: Validate JSON to Image Object.
            return image;
        }
    }
}
