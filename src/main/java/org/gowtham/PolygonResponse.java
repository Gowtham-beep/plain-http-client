package org.gowtham;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolygonResponse {
    private String ticker;
    private int queryCount;
    private int resultsCount;
    private List<Result> results;
    private String status;

    @JsonProperty("request_id")
    private String requestId;

    private int count;

    private boolean adjusted;  // <-- add this

    @Data
    public static class Result {
        @JsonProperty("T")
        private String ticker;

        @JsonProperty("v")
        private double volume;

        @JsonProperty("vw")
        private double volumeWeighted;

        @JsonProperty("o")
        private double open;

        @JsonProperty("c")
        private double close;

        @JsonProperty("h")
        private double high;

        @JsonProperty("l")
        private double low;

        @JsonProperty("t")
        private long timestamp;

        @JsonProperty("n")
        private int transactions;
    }
}
