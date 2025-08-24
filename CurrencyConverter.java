import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "4c65d0f0b99cc015b0fb3dc5"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter 'from' currency (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter 'to' currency (e.g., INR): ");
        String toCurrency = scanner.next().toUpperCase();

        try {
            double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) throws Exception {

        String urlString = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + fromCurrency;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Failed to fetch data from API. Response code: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        
        String response = content.toString();

        
        String searchString = "\"" + toCurrency + "\":";
        int startIndex = response.indexOf(searchString);

        if (startIndex == -1) {
            throw new Exception("Currency rate not found. Check the currency codes.");
        }

        int valueStartIndex = startIndex + searchString.length();
        int valueEndIndex = response.indexOf(",", valueStartIndex); 

        if (valueEndIndex == -1) {
             
            valueEndIndex = response.indexOf("}", valueStartIndex);
        }
        
        String rateString = response.substring(valueStartIndex, valueEndIndex);
        double rate = Double.parseDouble(rateString);

        return amount * rate;
    }
}