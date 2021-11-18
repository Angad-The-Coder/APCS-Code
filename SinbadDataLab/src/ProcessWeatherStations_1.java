import java.util.ArrayList;
import java.util.Scanner;
import core.data.*;

public class ProcessWeatherStations_1 {
   private static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      ProcessWeatherStations_1 pw1 = new ProcessWeatherStations_1();
      System.out.print(
            "Select your option.\n1 to test\n2 to prompt user for location\n3 to compare locations\n4 to quit: ");
      int choice = 0;
      try {
         choice = Integer.parseInt(in.nextLine());
      } catch (Exception e) {
         System.out.print("Invalid Entry!\n");
      }

      if (choice == 1) {
         pw1.testRetrieval();
      } else if (choice == 2) {
         String s = pw1.promptUserAndRetrieve();
         System.out.println(s);
      } else if (choice == 3) {
         String s = pw1.compareLocations();
         System.out.println(s);
      } else if (choice == 4) {
         in.close();
         System.exit(0);
      }
      main(args);// cycle back through if not quit

   }

   private void testRetrieval() {
      String id = "KATL";// ID of the weather station

      // the line below creates a connection with the selected
      // weather station.
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/" + id + ".xml");
      // need this line to initialize the data.
      ds.setCacheTimeout(15 * 60);

      ds.load();// retrieves the data
      ds.printUsageString();// shows the fields available

      // retrieves the temp_f field in the loaded DataSource
      // as a float (which is like a double)
      float temp = ds.fetchFloat("temp_f");

      // retrieves the location field which is a String
      String loc = ds.fetchString("location");
      System.out.println("The temperature at " + loc + " is " + temp + "F");
   }

   /**
    * Prompt the user for a location (more experienced coders should error-check the entry) and
    * return a String built of four weather attributes from that station.
    */
   private String promptUserAndRetrieve() {
      DataSource station =
            promptStationData("Enter the code for the weather station you'd like to observe:");

      // start the stationStr off with the station's location as a header:
      String stationStr = station.fetchString("location");

      // add more values:
      stationStr += "\n - Temperature: " + station.fetchFloat("temp_f") + "°F";
      stationStr += "\n - Dew Point: " + station.fetchFloat("dewpoint_f") + "°F";
      stationStr += "\n - Relative Humidity: " + station.fetchFloat("relative_humidity") + "%";
      stationStr += "\n - Wind Speed: " + station.fetchFloat("wind_mph") + "mph";

      return stationStr;
   }

   /**
    * Prompt the user for two (more experienced coders should prompt for more) stations and compare
    * them based on one (or more...) attribute(s) and then return a String that is built and
    * represents the results of the comparisons as a String
    */
   private String compareLocations() {
      // create an ArrayList to store all the stations that will be compared:
      ArrayList<DataSource> stations = new ArrayList<>();

      // add a user-inputted amount of weather stations to the stations ArrayList
      int stationCount = 0;
      while (true) {
         // at least 2 stations required to have any comparisons, it's up to the user if they want
         // to have more:
         if (stationCount >= 2) {
            System.out.println("Would you like to compare more weather stations? (Y/N)");
            String resp = in.nextLine();
            while (!resp.equals("Y") && !resp.equals("N")) {
               System.out.println("Please enter a 'Y' or a 'N':");
               resp = in.nextLine();
            }
            if (resp.equals("N")) {
               break;
            }
         }

         // if the user agrees to add more stations (or is required to), add a user-inputted station
         // to the stations ArrayList and increment stationCount by 1
         stations.add(promptStationData("Enter the code for weather station #" + (stationCount + 1)
               + " you would like to compare:"));
         stationCount++;
      }

      // prepare the comparisons of each station in stations as a String:
      String comparisonStr = "After comparing these weather stations, here are the results:";
      // find the station with the highest value for a given float field using the findMaxFloatField
      // helper method:
      String maxTemp = findMaxFloatField(stations, "temp_f").fetchString("location");
      comparisonStr += "\n - " + maxTemp + " has the highest temperature.";
      String maxDewpoint = findMaxFloatField(stations, "dewpoint_f").fetchString("location");
      comparisonStr += "\n - " + maxDewpoint + " has the highest dew point.";
      String maxHumidity = findMaxFloatField(stations, "relative_humidity").fetchString("location");
      comparisonStr += "\n - " + maxHumidity + " has the highest relative humidity.";
      String maxWind = findMaxFloatField(stations, "wind_mph").fetchString("location");
      comparisonStr += "\n - " + maxWind + " has the highest wind speed.";

      return comparisonStr;
   }

   /**
    * Prompts the user for a code corresponding to a weather station, and then validates this code
    * by attempting to load data from a weather station with this code and checking whether an error
    * occurs via try and catch. If the code is invalid, the user will be prompted to enter a new
    * one. Otherwise, the loaded DataSource of the user-inputted weather station code is returned.
    * 
    * This is used as a helper method for the promptUserAndRetrieve() and compareLocations()
    * functions.
    * 
    * @param prompt the String used to prompt the user for a weather station code
    * @return loaded DataSource of user-inputted weather station code
    */
   private DataSource promptStationData(String prompt) {
      System.out.println(prompt);

      String code = in.nextLine();
      DataSource station;
      while (true) {
         try {
            station = DataSource.connect("http://weather.gov/xml/current_obs/" + code + ".xml");
            station.setCacheTimeout(15 * 60);
            station.load();
            break;
         } catch (core.access.DataAccessException e) {
            // if the user's code is invalid and station.load() results in a
            // core.access.DataAccessException, we can prompt the user for a new code:
            System.out.println("That was an invalid code; please try again:");
            code = in.nextLine();
         }
      }
      // as we will only exit from the while loop above if the user's code is valid, we can rest
      // assured that station is valid at this point in the program and we can just return it:
      return station;
   }

   /**
    * Given an ArrayList of weather station DataSources and the field name of a float value that can
    * be used to compare each station with each other, find the station with the highest value for
    * this float field.
    * 
    * @param stations ArrayList of weather station DataSources
    * @param floatField he field name of a float value that can be used to compae each station with
    *        each other
    * @return the DataSource for the station with the highest value corresponding to the field name
    *         given by floatField
    */
   DataSource findMaxFloatField(ArrayList<DataSource> stations, String floatField) {
      if (stations.size() == 0) {
         return null;
      }
      DataSource max = stations.get(0);
      for (DataSource station : stations) {
         if (station.fetchFloat(floatField) > max.fetchFloat(floatField)) {
            max = station;
         }
      }
      return max;
   }
}
