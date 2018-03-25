
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.util.Random;
//import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.Response;

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
    public static void main(String args[]) throws MalformedURLException
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
            for(int j=0;j<locations[i].length;j++)
            {
                System.out.println("At Position "+i+" "+j);
                System.out.println(locations[i][j]);
            }
            try
            {
                System.out.println("Finding Address...\n");
                URL url=new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng="+locations[i][0]+","+locations[i][1]+"&key=AIzaSyDkUmLA-5-n5J2wE0QdrL9IQb5EFdon5qM");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) 
                {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
                
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) 
                {
                    System.out.println(output);	
                }
                conn.disconnect();
            }
            catch(IOException | RuntimeException e)
            {
                System.out.println("Error"+e);
//                e.printStackTrace();
            }
        }        
    }
}