/*
 * Arrays of objects
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessWeatherStationList {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ds.load();
      ArrayList<WeatherStation> allStns =
            ds.fetchList("WeatherStation", "station/station_name", "station/station_id",
                  "station/state", "station/latitude", "station/longitude", "station/xml_url");
      System.out.println("Total stations: " + allStns.size());

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.nextLine();

      // find all stations matching the user-inputted state:
      ArrayList<WeatherStation> stateStations = stateStnList(allStns, state);
      while (stateStations.size() == 0) {
         // if there are no stations match the user-inputted states, continually prompt the user for
         // a new state until it has stations in it:
         System.out.println("There are no records matching that abbreviation; try again: ");
         state = sc.nextLine();
         stateStations = stateStnList(allStns, state);
      }

      // print out stats about the user-inputted states
      System.out.println("Stations in " + state + ": " + stateStations.size());
      System.out.println("The station with the highest latitude in " + state + " is: "
            + maxLatitude(stateStations));
      System.out.println("The station with the highest longitude in " + state + " is: "
            + maxLongitude(stateStations));

      sc.close();

   }


   /**
    * Given an ArrayList of WeatherStations and a state abbreviation to find WeatherStations from,
    * return an ArrayList containing all the WeatherStations found that are in the inputted state.
    * 
    * @param stationList ArrayList of WeatherStations
    * @param state state abbreviation to find WeatherStations from
    * @return an ArrayList containing all the WeatherStations found that are in the inputted state
    */
   private static ArrayList<WeatherStation> stateStnList(ArrayList<WeatherStation> stationList,
         String state) {
      ArrayList<WeatherStation> stateStations = new ArrayList<>();
      for (WeatherStation station : stationList) {
         if (station.getState().equals(state)) {
            stateStations.add(station);
         }
      }
      return stateStations;
   }

   /**
    * Given an ArrayList of WeatherStations, return the WeatherStation with the highest latitude.
    * 
    * @param stationList ArrayList of WeatherStations
    * @return the WeatherStation with the highest latitude
    */
   private static WeatherStation maxLatitude(ArrayList<WeatherStation> stationList) {
      if (stationList.size() == 0)
         return null;

      WeatherStation maxStation = stationList.get(0);
      for (int i = 1; i < stationList.size(); i++) {
         WeatherStation currStation = stationList.get(i);
         if (currStation.getLatitude() > maxStation.getLatitude()) {
            maxStation = currStation;
         }
      }

      return maxStation;
   }

   /**
    * Given an ArrayList of WeatherStations, return the WeatherStation with the highest longitude.
    * 
    * @param stationList ArrayList of WeatherStations
    * @return the WeatherStation with the highest longitude
    */
   private static WeatherStation maxLongitude(ArrayList<WeatherStation> stationList) {
      if (stationList.size() == 0)
         return null;

      WeatherStation maxStation = stationList.get(0);
      for (int i = 1; i < stationList.size(); i++) {
         WeatherStation currStation = stationList.get(i);
         if (currStation.getLongitude() > maxStation.getLongitude()) {
            maxStation = currStation;
         }
      }

      return maxStation;
   }
}
