package wikisearch;

import wikisearch.parser.Parser;
import wikisearch.parser.SearchResultPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.spec.ECField;

public class RequestSender {

    private static final String apiString =
            "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";

    public void sendRequest(String request) throws MalformedURLException {
        request = URLEncoder.encode(request, StandardCharsets.UTF_8);
        String urlString = apiString + "\"" + request + "\"";
        System.out.println("after encoding: " + urlString);
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (InputStreamReader in = new InputStreamReader(connection.getInputStream())) {
            String response = getResponse(in);
//            System.out.println(response);
            Parser parser = new Parser(response);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getResponse(InputStreamReader in) throws IOException {
        int input;
        StringBuilder builder = new StringBuilder();
        while ((input = in.read()) != -1) {
            builder.append((char) input);
        }
        return builder.toString();
    }
}
