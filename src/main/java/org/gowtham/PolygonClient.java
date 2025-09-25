package org.gowtham;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
public class PolygonClient {
    private final HttpClient httpClient;
    private final ObjectMapper om;
    private final String apikey;
    private final String baseUrl;

    public PolygonClient(Config config){
        this.httpClient=HttpClient.newHttpClient();
        this.om= new ObjectMapper();
        this.apikey=config.get("polygon.api.key");
        this.baseUrl=config.get("polygon.base.url");
    }

    public PolygonResponse getPreviousClose(String ticker) throws IOException,InterruptedException{
        String url = baseUrl + ticker + "/prev?adjusted=true&apikey=" + apikey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        if(response.statusCode()== 200){
            return om.readValue(response.body(),PolygonResponse.class);
        }else{
            throw new RuntimeException("Failed with Status"+ response.statusCode());
        }
    }
}
