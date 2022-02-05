package com.criptojbc.criptojbcpracticajavafx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
public class Data {

    @JsonProperty("data")
    private List<Currencies> data = null;

    @JsonProperty("data")
    public List<Currencies> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Currencies> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }
}
