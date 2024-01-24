import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FootballAPI {
	String urlString;
	private String choice;

	public JSONObject getFootballData()
	{
		 String choice = null;
		JSONArray leagueData = getLeagueData(choice);


	
		try {
			HttpURLConnection conn= fetchApiResponse(urlString);
			if(conn.getResponseCode()!=200)
			{
				 System.out.println("Error!! : Could not connect to API");
				 return null;
			}
			else
			{
				
				
				
				
					
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
}

	public JSONArray getLeagueData(String choice) {
		String urlString="";
	
		switch(choice)
		{
		case "spainBtn": 
		urlString= "https://v3.football.api-sports.io/leagues";
			 
	    break;
		case "englandBtn": 
			urlString= "https://v3.football.api-sports.io/leagues";
			 
	    break;
		case "italyBtn": 
			  urlString= "https://v3.football.api-sports.io/leagues";
			 
	    break;
		case "iranBtn": 
			 urlString = "https://v3.football.api-sports.io/leagues";
			 
	    break;
		case "germanyBtn": 
			 urlString =  "https://v3.football.api-sports.io/leagues";
	    break;
		case "franceBtn": 
			 urlString =  "https://v3.football.api-sports.io/leagues";
			 
	    break;
		case "worldCupBtn": 
			 urlString =  "https://v3.football.api-sports.io/leagues";
	    break;
	    default:
	    	System.out.println("error!!!");
	    	break;
		}
	
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
		       
		    }
			return null;
			
	}
	 private static HttpURLConnection fetchApiResponse(String urlString){
	        try{
	            URL url= new URL(urlString);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("x-rapidapi-key","f52db1114b2d80e1e563c0402e7980c3");
	            conn.setRequestProperty("x-rapidapi-host", "v3.football.api-sports.io");
	            conn.connect();
	            return conn;
	        } catch (IOException e){
	        e.printStackTrace();
	    }
	        return null;

	}
}
