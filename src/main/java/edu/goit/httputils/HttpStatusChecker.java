package edu.goit.httputils;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpStatusChecker {


    public String getStatusImage(int code) throws IOException {

        String strUrl = "https://http.cat/" + code + ".jpg";
        URL url = new URL(strUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() == 200) {
            return connection.getURL().toString();
        } else {
            throw new RuntimeException("Wrong code");
        }

    }
}
