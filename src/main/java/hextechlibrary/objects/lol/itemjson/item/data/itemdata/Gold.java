package hextechlibrary.objects.lol.itemjson.item.data.itemdata;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "base",
        "purchasable",
        "total",
        "sell"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = Gold.Builder.class)
public class Gold {

    @JsonProperty("base")
    private final int base;
    @JsonProperty("purchasable")
    private final boolean purchasable;
    @JsonProperty("total")
    private final int total;
    @JsonProperty("sell")
    private final int sell;

    public Gold(Builder builder) {
        this.base = builder.base;
        this.purchasable = builder.purchasable;
        this.total = builder.total;
        this.sell = builder.sell;
    }

    public int getBase() {
        return base;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public int getTotal() {
        return total;
    }

    public int getSell() {
        return sell;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private Integer base;
        private Boolean purchasable;
        private Integer total;
        private Integer sell;

        Builder withBase(int base) {
            this.base = base;
            return this;
        }

        Builder withPurchasable(boolean purchasable) {
            this.purchasable = purchasable;
            return this;
        }

        Builder withTotal(int total) {
            this.total = total;
            return this;
        }

        Builder withSell(int sell) {
            this.sell = sell;
            return this;
        }

        public Gold build(){
            Gold gold = new Gold(this);
            //TODO: Validate JSON to Object.
            return gold;
        }
    }
}