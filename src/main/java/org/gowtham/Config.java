package org.gowtham;

import java.io.IOException;
import java.io.InputStream;
import  java.util.Properties;

public class Config {
    private final Properties props = new Properties();

    public Config(String filename){
        try(InputStream input = getClass().getClassLoader().getResourceAsStream(filename)){
            if(input == null){
                throw new RuntimeException("Unable to find" + filename);
            }
            props.load(input);
        }catch (IOException e) {
            throw new RuntimeException("Error loading properties file", e);
        }
    }
    public String get(String key){
        return props.getProperty(key);
    }
}
