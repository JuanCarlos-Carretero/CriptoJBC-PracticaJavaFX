package com.criptojbc.criptojbcpracticajavafx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
/**
 * Esta Clase es donde se guardara la lista de las Currencies.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
public class Data {

    @JsonProperty("data")
    private List<Currencies> data = null;

    /**
     * Este metodo sirve para saber cual es la lista data o recibirla.
     * @return Retorna la lista data.
     */
    @JsonProperty("data")
    public List<Currencies> getData() {
        return data;
    }

    /**
     * Cambiamos la lista data por otra.
     * @param data Este parametro es la lista data por la que se va a cambiar.
     */
    @JsonProperty("data")
    public void setData(List<Currencies> data) {
        this.data = data;
    }

    /**
     * Este metodo sirve para convertir a String cualquier objeto Java.
     * @return El objeto Java convertido en String.
     */
    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }
}
