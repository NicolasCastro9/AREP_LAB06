package edu.escuelaing.arem.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HTTPConection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String[] LOG_SERVERS = new String[] { "http://service1:4567/logservice?message=",
            "http://service2:4567/logservice?message=",
            "http://service3:4567/logservice?message=",
    };

    private static int currentServer = 0;



     public static List<String> getLogs(String message) throws IOException, MalformedURLException, ProtocolException {
        String GET_URL = rotateRoundRobinServer() + message;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);


        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            List<String> response = new ArrayList<>();

            while ((inputLine = in.readLine()) != null) {
                response.add(inputLine);
            }
            in.close();


            System.out.println(response.toString());
            System.out.println("GET DONE");
            return response;

        } else {
            System.out.println("GET request not worked");
        }

        return null;
    }

    public static String rotateRoundRobinServer() {
        currentServer = (currentServer + 1) % LOG_SERVERS.length;
        System.out.println( "Server : "  + LOG_SERVERS[currentServer]);
        return LOG_SERVERS[currentServer];
    }
}