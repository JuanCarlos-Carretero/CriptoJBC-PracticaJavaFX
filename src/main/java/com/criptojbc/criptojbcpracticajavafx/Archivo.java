package com.criptojbc.criptojbcpracticajavafx;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Archivo {
    Data data;
    
    public void descargar() {
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

        LectorJSON lJ = new LectorJSON();
        try {
            data = lJ.JSONsimple();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
