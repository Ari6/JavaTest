package NetworkTest;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            String urlName;
            if (args.length > 0) {
                urlName = args[0];
            } else {
                urlName = "https://google.com";
            }

            var url = new URL(urlName);
            //Step 1
            URLConnection connection = url.openConnection();

            if (args.length > 2) {
                String username = args[1];
                String password = args[2];
                String input = username + ":" + password;
                Base64.Encoder encoder = Base64.getEncoder();
                String encoding =
                        encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));

                //Step 2
                connection.setRequestProperty("Authorization", "Basic " + encoding);
            }

            //Step 3
            connection.connect();

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key + ": " + value);
                }
            }

            //Step 4
            System.out.println("-----------");
            System.out.println("getContexntType: " + connection.getContentType());
            System.out.println("getContexntLength: " + connection.getContentLength());
            System.out.println("getContexntEncoding: " + connection.getContentEncoding());
            System.out.println("getDate: " + connection.getDate());
            System.out.println("getExpiration: " + connection.getExpiration());
            System.out.println("getLastModified: " + connection.getLastModified());
            System.out.println("-----------");

            String encoding = connection.getContentEncoding();
            if (encoding == null) {
                encoding = "UTF-8";
            }

            //Step 5
            try (var in = new Scanner(connection.getInputStream(), encoding)) {
                for (int n = 1; in.hasNextLine() && n <= 10; n++) {
                    System.out.println(in.nextLine());
                    if (in.hasNextLine()) {
                        System.out.println(". . .");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
