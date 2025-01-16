package service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Currency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateService {
    private static final String API_URL = "https://data.fixer.io/api/latest?access_key=74e64d8845dda5dbb24767fb4870c1c9";

    public double getExchangeRate(Currency from, Currency to) throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Failed to connect to the API: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
        if (!jsonResponse.get("success").getAsBoolean()) {
            throw new RuntimeException("API error: " + jsonResponse.get("error").getAsJsonObject().get("info").getAsString());
        }

        JsonObject rates = jsonResponse.getAsJsonObject("rates");
        double fromRate = rates.get(from.getCode()).getAsDouble();
        double toRate = rates.get(to.getCode()).getAsDouble();

        return toRate / fromRate;
    }
}

