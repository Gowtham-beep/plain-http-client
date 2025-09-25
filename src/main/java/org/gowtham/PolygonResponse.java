package org.gowtham;

import lombok.Data;

import java.util.List;
@Data
public class PolygonResponse {
    private String ticker;
    private int queryCount;
    private int resultsCount;
    private List<Result> results;
    private String status;
    private String request_id;
    private int count;

    @Data
    public static class Result{
        private String T;
        private double v;
        private double vw;
        private double o;
        private double c;
        private double h;
        private double l;
        private long t;
        private int n;

    }
}
