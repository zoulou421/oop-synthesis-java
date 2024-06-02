package com.formationkilo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataTransformationUtils {
    public static  String toJson(Object o){
        ObjectMapper objectMapper=new ObjectMapper();
        String json=null;
        try {
            json=objectMapper.writeValueAsString(o);
            return json;
        }catch (JsonProcessingException e){
            return "{}";
        }
    }
}
