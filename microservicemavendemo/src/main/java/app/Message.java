package app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private long id;
    private String content;

    public Message() {
        // Json serialization
    }

    public Message(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
