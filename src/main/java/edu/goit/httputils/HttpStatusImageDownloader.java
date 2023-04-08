package edu.goit.httputils;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException {
        var httpStatusChecker = new HttpStatusChecker();
        String imageUrl = httpStatusChecker.getStatusImage(code);

        String destinationFile = code + ".jpg";
        URL url = new URL(imageUrl);
        URLConnection connection = url.openConnection();
        try (BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

}
