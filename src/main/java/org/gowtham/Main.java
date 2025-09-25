package org.gowtham;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
        Config config = new Config("config.properties");
        PolygonClient client = new PolygonClient(config);

        PolygonResponse response = client.getPreviousClose("AAPL");

        System.out.println("Ticker: "+ response.getTicker());
        System.out.println("Close Price:"+ response.getResults().ge);
    }
}