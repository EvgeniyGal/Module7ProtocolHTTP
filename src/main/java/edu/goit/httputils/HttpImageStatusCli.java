package edu.goit.httputils;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public static void main(String[] args) {

        var downloader = new HttpStatusImageDownloader();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");

        boolean isOk = false;
        String code = "";

        while (!isOk) {
            code = scanner.nextLine();
            if (code.matches("\\d{3}")) {
                isOk = true;
            } else {
                System.out.println("Please enter valid number");
            }
        }
        scanner.close();

        try {
            downloader.downloadStatusImage(Integer.parseInt(code));
        } catch (IOException e){
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}