import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.text.html.parser.Parser;

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
				StringBuilder resultJson= new StringBuilder();
				Scanner scanner = new Scanner(conn.getInputStream());

				while (scanner.hasNext()){
					resultJson.append(scanner.nextLine());
				}

				scanner.close();
				conn.disconnect();

				JSONParser parser= new JSONParser();
				JSONObject resultJsonObj= (JSONObject) parser.parse(String.valueOf(resultJson));

				JSONArray response= (JSONArray) resultJsonObj.get("response");

				for(int i=1;i< response.toArray().length;i++) {
	JSONObject fixtures =(JSONObject) response.get(i);

	JSONObject teams = (JSONObject) fixtures.get("teams");
	JSONObject homeTeam = (JSONObject) teams.get("home");
					String nameHTeam = (String) homeTeam.get("name");
					boolean winnerHTeam= (boolean) homeTeam.get("winner");
	JSONObject awayTeam = (JSONObject) teams.get("away");
					String nameATeam = (String) awayTeam.get("name");
					boolean winnerATeam= (boolean) awayTeam.get("winner");


	JSONObject fixturesInfo= (JSONObject) fixtures.get("fixture");
	String referee = (String) fixturesInfo.get("referee");


	JSONObject goals = (JSONObject) fixtures.get("goals");
int hTeamGoals= (int) goals.get("home");
int aTeamGoals =(int) goals.get("away");

JSONObject status= (JSONObject) fixturesInfo.get("status");
String shortStatus= (String) status.get("short");

String date= (String) fixturesInfo.get("date");

JSONObject total= new JSONObject();
total.put("match",i);
total.put("date",date);
total.put("team A name",nameHTeam);
total.put("team B name",nameATeam);
total.put("team A goals",hTeamGoals);
total.put("team B goals", aTeamGoals);
total.put("referee",referee);

//resultJson.append("match:"+i+" date:"+date+" first team name:"+ nameHTeam+ " second team name:"+ nameATeam +" status:"+ status+" first team goals:"+ hTeamGoals+" second team goals:"+ aTeamGoals+ " referee:"+ referee);
return total;
}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
}

	public JSONArray getLeagueData(String choice) {

	String leagueId="";
		switch(choice)
		{
		case "spainBtn": 
		leagueId="141";
			 
	    break;
		case "englandBtn":
			leagueId="39";
			 
	    break;
		case "italyBtn":
			leagueId="135";
			 
	    break;
		case "iranBtn":
			leagueId="290";
			 
	    break;
		case "germanyBtn":
			leagueId="78";
	    break;
		case "franceBtn":
			leagueId="61";
			 
	    break;
		case "worldCupBtn":
			leagueId="15";
	    break;
	    default:
	    	System.out.println("error!!!");
	    	break;
		}
		 urlString="https://v3.football.api-sports.io/fixtures?league="+leagueId+"&season=2023";
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
	            conn.setRequestProperty("x-apisports-key","f52db1114b2d80e1e563c0402e7980c3");
	            conn.setRequestProperty("x-rapidapi-host", "v3.football.api-sports.io");
	            conn.connect();
	            return conn;
	        } catch (IOException e){
	        e.printStackTrace();
	    }
	        return null;

	}
}
