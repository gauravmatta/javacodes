
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav Matta
 */
public class location {
    public static void main(String args[])
    {
        int latMin=-85;
        int latmax=85;
        int longMin=-180;
        int longmax=180;
        int [][] locations=new int [10][2];
        for (int[] location : locations) {
            Random r = new Random();
            int randLat=r.nextInt(latmax - latMin + 1) + latMin;
            int randLong=r.nextInt(longmax - longMin + 1) + longMin;
            location[0] = randLat;
            location[1] = randLong;
        }
        
        for(int i = 0; i<locations.length; i++) 
        {
            System.out.println("At Longitude and Latitude");
            for(int j=0;j<locations[i].length;j++)
            {
                System.out.println(locations[i][j]);
            }
            
            try
            {
                URL url=new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng="+locations[i][0]+","+locations[i][1]+"&key=AIzaSyDkUmLA-5-n5J2wE0QdrL9IQb5EFdon5qM");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) 
                {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
                StringBuilder str = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output;
                while ((output = br.readLine()) != null) 
                {
                    str.append(output).append("\n");
                }
                conn.disconnect();
                 
                String result;
                result=str.toString();
                JSONParser parser = new JSONParser();
                try
                {
                    Object obj = parser.parse(result);
                    JSONObject obj2 = (JSONObject)obj;
                    JSONArray results=(JSONArray)obj2.get("results");
                    if(!(results.isEmpty()))
                    {
                        JSONObject obj3=(JSONObject)results.get(0);
                        JSONArray address_components=(JSONArray) obj3.get("address_components");
                        if(!(address_components.isEmpty()))
                        {
                            for(Object obj4:address_components)
                            {
                               JSONObject obj5=(JSONObject) obj4;
                               JSONArray types=(JSONArray)obj5.get("types");
                               if(types.contains("country"))
                               {
                                   Object long_name=obj5.get("long_name");
                                   System.out.println("You are in "+long_name);
                               }
                            }
                        }
                    }
                    else
                    {
                        System.out.println("You are in Water");
                    }
                    
                }
                catch(ParseException e)
                {
                    System.out.println("Error"+e);
                }
            }
            catch(IOException | RuntimeException e)
            {
                System.out.println("Error"+e);
            }
            
        }
    }
}