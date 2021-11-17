import java.util.ArrayList;

/*
 Represents information about a NWS weather station
*/

public class WeatherStation {
   private String name;
   private String id;
   private ArrayList<Observation> observations;

   WeatherStation(String name, String id) {
      this.name = name;
      this.id = id;
   }
   WeatherStation(String name, String id, String state) {
      this.name = name;
      this.id = id;
   }
   
   /* Produce the id of this station */
   public String getId() { 
      return id;
   }
   
   /* Produce the name of this station */
   public String getName() { 
      return name;
   }
  
   
}