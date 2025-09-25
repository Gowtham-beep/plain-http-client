
# Polygon API Java Client

This is a simple Java HTTP client that fetches stock data from the [Polygon.io](https://polygon.io/) API and maps the JSON response into Java objects using **Jackson** and **Lombok**.

---

## Features

* Fetches stock data (e.g., daily open/close, volume, etc.) from Polygon.
* Maps API response to Java POJOs (`PolygonResponse`, `Result`).
* Uses **Lombok** for boilerplate (`@Data` generates getters/setters).
* Handles unknown JSON fields safely with `@JsonIgnoreProperties`.

---

## Requirements

* Java 17+
* Maven
* Polygon.io API Key (free tier works)

---

## How It Works

1. The client sends an HTTP request to Polygon’s API.
2. The JSON response is deserialized into `PolygonResponse` using Jackson.
3. Stock details (ticker, open, close, high, low, volume, etc.) can be accessed via Java objects.

Example API response field mapping:

```json
{
  "ticker": "AAPL",
  "queryCount": 1,
  "resultsCount": 1,
  "adjusted": true,
  "results": [
    {
      "T": "AAPL",
      "o": 185.0,
      "c": 187.0,
      "h": 188.0,
      "l": 184.5,
      "v": 120000,
      "t": 1695600000000
    }
  ]
}
```

---

## Usage

```bash
mvn clean compile exec:java -Dexec.mainClass="org.gowtham.Main"
```

The program will:

* Call the Polygon API.
* Print the ticker and stock details to the console.

---

## Future Enhancements

* Add support for multiple endpoints (e.g., `/v3/reference/tickers`, `/v2/aggs/ticker`).
* Implement error handling (invalid ticker, expired API key).
* Add caching to reduce API calls.
* Unit tests with mocked API responses.


