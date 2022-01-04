package hextechlibrary.objects.lol.itemjson.item.data.itemdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Effect.Builder.class)
public class Effect {
    @JsonProperty("Effect1Amount")
    private final String effect1Amount;
    @JsonProperty("Effect2Amount")
    private final String effect2Amount;
    @JsonProperty("Effect3Amount")
    private final String effect3Amount;
    @JsonProperty("Effect4Amount")
    private final String effect4Amount;
    @JsonProperty("Effect5Amount")
    private final String effect5Amount;
    @JsonProperty("Effect6Amount")
    private final String effect6Amount;
    @JsonProperty("Effect7Amount")
    private final String effect7Amount;
    @JsonProperty("Effect8Amount")
    private final String effect8Amount;
    @JsonProperty("Effect9Amount")
    private final String effect9Amount;
    @JsonProperty("Effect10Amount")
    private final String effect10Amount;
    @JsonProperty("Effect11Amount")
    private final String effect11Amount;
    @JsonProperty("Effect12Amount")
    private final String effect12Amount;
    @JsonProperty("Effect13Amount")
    private final String effect13Amount;
    @JsonProperty("Effect14Amount")
    private final String effect14Amount;
    @JsonProperty("Effect15Amount")
    private final String effect15Amount;
    @JsonProperty("Effect16Amount")
    private final String effect16Amount;
    @JsonProperty("Effect17Amount")
    private final String effect17Amount;
    @JsonProperty("Effect18Amount")
    private final String effect18Amount;

    public Effect(Builder builder) {
        this.effect1Amount = builder.effect1Amount;
        this.effect2Amount = builder.effect2Amount;
        this.effect3Amount = builder.effect3Amount;
        this.effect4Amount = builder.effect4Amount;
        this.effect5Amount = builder.effect5Amount;
        this.effect6Amount = builder.effect6Amount;
        this.effect7Amount = builder.effect7Amount;
        this.effect8Amount = builder.effect8Amount;
        this.effect9Amount = builder.effect9Amount;
        this.effect10Amount = builder.effect10Amount;
        this.effect11Amount = builder.effect11Amount;
        this.effect12Amount = builder.effect12Amount;
        this.effect13Amount = builder.effect13Amount;
        this.effect14Amount = builder.effect14Amount;
        this.effect15Amount = builder.effect15Amount;
        this.effect16Amount = builder.effect16Amount;
        this.effect17Amount = builder.effect17Amount;
        this.effect18Amount = builder.effect18Amount;
    }

    public String getEffect1Amount() {
        return effect1Amount;
    }

    public String getEffect2Amount() {
        return effect2Amount;
    }

    public String getEffect3Amount() {
        return effect3Amount;
    }

    public String getEffect4Amount() {
        return effect4Amount;
    }

    public String getEffect5Amount() {
        return effect5Amount;
    }

    public String getEffect6Amount() {
        return effect6Amount;
    }

    public String getEffect7Amount() {
        return effect7Amount;
    }

    public String getEffect8Amount() {
        return effect8Amount;
    }

    public String getEffect9Amount() {
        return effect9Amount;
    }

    public String getEffect10Amount() {
        return effect10Amount;
    }

    public String getEffect11Amount() {
        return effect11Amount;
    }

    public String getEffect12Amount() {
        return effect12Amount;
    }

    public String getEffect13Amount() {
        return effect13Amount;
    }

    public String getEffect14Amount() {
        return effect14Amount;
    }

    public String getEffect15Amount() {
        return effect15Amount;
    }

    public String getEffect16Amount() {
        return effect16Amount;
    }

    public String getEffect17Amount() {
        return effect17Amount;
    }

    public String getEffect18Amount() {
        return effect18Amount;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static class Builder{
        private String effect1Amount;
        private String effect2Amount;
        private String effect3Amount;
        private String effect4Amount;
        private String effect5Amount;
        private String effect6Amount;
        private String effect7Amount;
        private String effect8Amount;
        private String effect9Amount;
        private String effect10Amount;
        private String effect11Amount;
        private String effect12Amount;
        private String effect13Amount;
        private String effect14Amount;
        private String effect15Amount;
        private String effect16Amount;
        private String effect17Amount;
        private String effect18Amount;

        public Builder witheffect1Amount(String effect){
            this.effect1Amount = effect;
            return this;
        }
        public Builder witheffect2Amount(String effect){
            this.effect2Amount = effect;
            return this;
        }
        public Builder witheffect3Amount(String effect){
            this.effect3Amount = effect;
            return this;
        }
        public Builder witheffect4Amount(String effect){
            this.effect4Amount = effect;
            return this;
        }
        public Builder witheffect5Amount(String effect){
            this.effect5Amount = effect;
            return this;
        }
        public Builder witheffect6Amount(String effect){
            this.effect6Amount = effect;
            return this;
        }
        public Builder witheffect7Amount(String effect){
            this.effect7Amount = effect;
            return this;
        }
        public Builder witheffect8Amount(String effect){
            this.effect8Amount = effect;
            return this;
        }
        public Builder witheffect9Amount(String effect){
            this.effect9Amount = effect;
            return this;
        }
        public Builder witheffect10Amount(String effect){
            this.effect10Amount = effect;
            return this;
        }
        public Builder witheffect11Amount(String effect){
            this.effect11Amount = effect;
            return this;
        }
        public Builder witheffect12Amount(String effect){
            this.effect12Amount = effect;
            return this;
        }
        public Builder witheffect13Amount(String effect){
            this.effect13Amount = effect;
            return this;
        }
        public Builder witheffect14Amount(String effect){
            this.effect14Amount = effect;
            return this;
        }
        public Builder witheffect15Amount(String effect){
            this.effect15Amount = effect;
            return this;
        }
        public Builder witheffect16Amount(String effect){
            this.effect16Amount = effect;
            return this;
        }
        public Builder witheffect17Amount(String effect){
            this.effect17Amount = effect;
            return this;
        }
        public Builder witheffect18Amount(String effect){
            this.effect18Amount = effect;
            return this;
        }

        public Effect build(){
            Effect effect = new Effect(this);
            //TODO: Validate Effct json to Object;
            return effect;
        }
        
    }
}
