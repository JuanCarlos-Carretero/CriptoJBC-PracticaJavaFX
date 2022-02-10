package com.criptojbc.criptojbcpracticajavafx;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Esta clase es la que se encarga de lo relacionado con el archivo.
 */
public class Archivo {
    Data data;

    /**
     * Este metodo permite descargar el archivo desde una API.
     */
    public void Descargar() {
        String url = "https://api.coinbase.com/v2/currencies"; //dirección url del recurso a descargar
        String name = "response.json"; //nombre del archivo destino
        //Directorio destino para las descargas
        String folder = "src/main/resources/";

        //Crea el directorio de destino en caso de que no exista
        File dir = new File(folder);

        if (!dir.exists())
            if (!dir.mkdir())
                return; // no se pudo crear la carpeta de destino
        File file = new File(folder + name);
        URLConnection conn = null;
        try {
            conn = new URL(url).openConnection();
            conn.connect();
        } catch (
                MalformedURLException e) {
            System.out.println("la url: " + url + " no es valida!");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nEmpezando Descarga: \n");
        System.out.println(">> URL: " + url);
        System.out.println(">> Nombre: " + name);
        System.out.println(">> tamaño: " + conn.getContentLength() + " bytes");

        InputStream in = null;
        try {
            in = conn.getInputStream();
            OutputStream out = new FileOutputStream(file);
            int b = 0;
            while (b != -1) {
                b = in.read();
                if (b != -1)
                    out.write(b);
            }

            out.close();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            data = Leer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Este metodo permite leer el archivo descargado desde la API y guardarlo en un Objeto Data.
     * @return Retorna una lista de Currencies.
     * @throws Exception es la clase base para excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     */
    public Data Leer() throws Exception {
        // parsing file "JSONExample.json"
        data = new ObjectMapper().readValue(new File("src/main/resources/response.json"), Data.class);

        // typecasting ob to JSONObject
        System.out.println(data.getData());

        System.out.println(data.getData().size());
        return data;
    }
}
