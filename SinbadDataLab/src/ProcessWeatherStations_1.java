import java.util.Scanner;

import core.data.*;

public class ProcessWeatherStations_1 {
   public static void main(String[] args) {
      ProcessWeatherStations_1 pw1 = new ProcessWeatherStations_1();
      System.out.print("Select your option.\n1 to test\n2 to prompt user for location\n3 to compare locations\n4 to quit: ");
      Scanner in = new Scanner(System.in);
      int choice = 0;
      try{
         choice = Integer.parseInt(in.nextLine());
      }
      catch(Exception e){
         System.out.print("Invalid Entry!\n");
      }
       
      if(choice == 1){
         pw1.testRetrieval();
      }
      else if(choice == 2){
         String s = pw1.promptUserAndRetrieve();
         System.out.println(s);
      }
      else if(choice == 3){
         String s = pw1.compareLocations();
         System.out.println(s);
      }
      else if(choice == 4){
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
   * Prompt the user for a location (more experienced coders should error-check the entry)
   * and return a String built of four weather attributes from that station.
   */
   private String promptUserAndRetrieve() {
      return null;
   }
   
   /**
    * Prompt the user for two (more experienced coders should prompt for more) stations
    * and compare them based on one (or more...) attribute(s) and then return a String
    * that is built and represents the results of the comparisons as a String
    */
   private String compareLocations() {
      return null;
   }

}
