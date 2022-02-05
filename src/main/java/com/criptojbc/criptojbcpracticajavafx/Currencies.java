package com.criptojbc.criptojbcpracticajavafx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "min_size"
})
public class Currencies {

    @Override
    public String toString() {
        return "Currencies{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", minSize='" + minSize + '\'' +
                '}';
    }
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("min_size")
    private String minSize;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("min_size")
    public String getMinSize() {
        return minSize;
    }

    @JsonProperty("min_size")
    public void setMinSize(String minSize) {
        this.minSize = minSize;
    }

}