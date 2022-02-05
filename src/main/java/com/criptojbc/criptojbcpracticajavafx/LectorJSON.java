package com.criptojbc.criptojbcpracticajavafx;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class LectorJSON {
    Data data;
    public Data JSONsimple() throws Exception {
        // parsing file "JSONExample.json"
        data = new ObjectMapper().readValue(new File("C:\\Users\\Juan Carlos\\IdeaProjects\\CriptoJBC\\src\\main\\resources\\response.json"), Data.class);

        // typecasting ob to JSONObject
        System.out.println(data.getData());

        System.out.println(data.getData().size());
        return data;
    }
}

