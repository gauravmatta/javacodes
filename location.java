
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
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
        String [][][] vistor_list=new String [locations.length][locations.length][];
        String [] country = new String[locations.length];
        String [] adminsitrative_area1 = new String [locations.length];
        int nextCountryindex=0;
        int nextaal1index=1;
        int aa1Index=0;
        int countryIndex=0;
        Object admin_area_name=null;
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
                               if(types.contains("administrative_area_level_1"))
                               {
                                   Object long_name=obj5.get("long_name");
                                   List<String> list = Arrays.asList(adminsitrative_area1);
                                   if(list.contains((String)long_name))
                                   {
                                       aa1Index=list.indexOf(long_name);
                                   }
                                   else
                                   {
                                       adminsitrative_area1[nextaal1index++]=(String)long_name;
                                   }
                               }
                               if(types.contains("country"))
                               {
                                   Object long_name=obj5.get("long_name");
                                   System.out.println("Country : "+long_name);
                                   List<String> list = Arrays.asList(country);
                                   if(list.contains((String)long_name))
                                   {
                                       countryIndex=list.indexOf(long_name);
                                   }
                                   else
                                   {
                                       countryIndex=nextCountryindex++;
                                       country[countryIndex]=(String)long_name;
                                   }
//                                 Object long_name=obj5.get("long_name");
//                                 System.out.println("You are in "+long_name);
                               }
                               if(types.contains("administrative_area_level_2"))
                               {
                                   admin_area_name=obj5.get("long_name");
                               }
                            }
                            List<String> list = Arrays.asList(vistor_list[countryIndex][aa1Index]);
                            if ((admin_area_name!=null) && !list.contains((String)admin_area_name))
                            {
                                int index=list.size()-1;
                                vistor_list[countryIndex][aa1Index][index]=(String)admin_area_name;
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
        
        for(int i = 0; i<vistor_list.length; i++)
        {
            for(int j=0;j<vistor_list[i].length;j++)
            {
                for(int k=0;k<vistor_list[i][j].length;k++)
                {
                    System.out.println(i+" "+j+" "+k);
                    System.out.println(vistor_list[i][j][k]);
                }
            }
        }
    }
}