package com.criptojbc.criptojbcpracticajavafx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
/**
 * Esta Clase es donde se guardaran todos los datos de cada una de las Currencies en solitario.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "min_size"
})
public class Currencies {
    /**
     * Este metodo sirve para convertir a String cualquier objeto Java.
     * @return El objeto Java convertido en String.
     */
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

    /**
     * Este metodo sirve para saber cual es la id o recibirla.
     * @return Retorna la ID de la currencie.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Cambiamos la id de la currencie por otra.
     * @param id Este parametro es la id por la que se va a cambiar.
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Este metodo sirve para saber cual es el Nombre o recibirlo.
     * @return Retorna el Nombre de la currencie.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Cambiamos el Nombre de la currencie por otro.
     * @param name Este parametro es el Nombre por el que se va a cambiar.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Este metodo sirve para saber cual es el Precio minimo o recibirlo.
     * @return Retorna el Precio minimo de la currencie.
     */
    @JsonProperty("min_size")
    public String getMinSize() {
        return minSize;
    }

    /**
     * Cambiamos el Precio Minimo de la currencie por otro.
     * @param minSize Este parametro es el Precio Minimo por el que se va a cambiar.
     */
    @JsonProperty("min_size")
    public void setMinSize(String minSize) {
        this.minSize = minSize;
    }

}