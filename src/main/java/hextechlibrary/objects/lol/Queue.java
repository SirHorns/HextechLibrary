package hextechlibrary.objects.lol;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Queue.Builder.class)
public class Queue {
    private final int queueId;
    private final String map;
    private final String description;
    private final String notes;

    public Queue(Builder builder) {
        this.queueId = builder.queueId;
        this.map = builder.map;
        this.description = builder.description;
        this.notes = builder.notes;
    }

    public int getQueueId() {
        return queueId;
    }

    public String getMap() {
        return map;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private int queueId;
        private String map;
        private String description;
        private String notes;

        Builder withQueueId(int queueId){
            this.queueId = queueId;
            return this;
        }
        Builder withMap(String map){
            this.map = map;
            return this;
        }
        Builder withDescription(String description){
            this.description = description;
            return this;
        }
        Builder withNotes(String notes){
            this.notes = notes;
            return this;
        }

        public Queue build(){
            Queue queue = new Queue(this);
            validateUserObject(queue);
            return queue;
        }

        private void validateUserObject(Queue queue) {
            //TODO: Validate JSON to Object.
        }
    }
}
