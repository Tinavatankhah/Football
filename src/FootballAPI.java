import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class FootballAPI {

    String ApiKey ="f52db1114b2d80e1e563c0402e7980c3";
    private static HttpURLConnection fetchApiResponse(String urlString){
        try{
            URL url= new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("Get");
            conn.setRequestProperty("x-rapidapi-key","f52db1114b2d80e1e563c0402e7980c3");
            conn.setRequestProperty("x-rapidapi-host", "v3.football.api-sports.io");
            conn.connect();
            return conn;
        } catch (IOException e){
        e.printStackTrace();
    }
        return null;

}
    public static void main(String[] args) {
String urlString= "https://v3.football.api-sports.io/leagues";
    HttpURLConnection conn = fetchApiResponse(urlString);
    if(conn != null)

    {

        try {

            if (conn.getResponseCode() != 200) {
                System.out.println("Error: could not connect to API");
            }
            StringBuilder resultJson = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNext()) {
                resultJson.append(scanner.nextLine());
            }
            scanner.close();
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}}