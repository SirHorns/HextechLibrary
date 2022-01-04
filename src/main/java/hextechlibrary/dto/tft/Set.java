package hextechlibrary.dto.tft;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Set.Builder.class)
public class Set {
    private final String style;
    private final int min;
    private final int max;

    public Set(Builder builder) {
        this.style = builder.style;
        this.min = builder.min;
        this.max = builder.max;
    }

    public String getStyle() {
        return style;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String style;
        private int min;
        private int max;

        Builder withStyle(String style){
            this.style = style;
            return this;
        }
        Builder withMin(int min){
            this.min = min;
            return this;
        }
        Builder withMax(int max){
            this.max = max;
            return this;
        }

        public Set build(){
            Set set = new Set(this);
            validateUserObject(set);
            return set;
        }

        private void validateUserObject(Set set) {
            //TODO: Object Valudation
        }
    }
}
