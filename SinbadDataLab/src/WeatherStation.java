import java.util.ArrayList;

/*
 * Represents information about a NWS weather station
 */

public class WeatherStation {
   private String name;
   private String id;
   private String state;
   private float latitude;
   private float longitude;
   private String observationURL;

   WeatherStation(String name, String id) {
      this.name = name;
      this.id = id;
   }

   WeatherStation(String name, String id, String state, float latitude, float longitude,
         String observationUrl) {
      this.name = name;
      this.id = id;
      this.state = state;
      this.latitude = latitude;
      this.longitude = longitude;
      this.observationURL = observationUrl;
   }

   /* Produce the id of this station */
   public String getId() {
      return this.id;
   }

   /* Produce the name of this station */
   public String getName() {
      return this.name;
   }

   /* Produce the state of this station */
   public String getState() {
      return this.state;
   }

   /* Produce the latitude of this station */
   public float getLatitude() {
      return this.latitude;
   }

   /* Produce the longitude of this station */
   public float getLongitude() {
      return this.longitude;
   }

   /* Produce the longitude of this station */
   public String getObservationUrl() {
      return this.observationURL;
   }

   /**
    * toString() method, including the WeatherStation's name and (latitude, longitude) coordinates.
    * Negative latitude or longitude coordinates are made positive and indicated to be in their
    * respective hemispheres.
    */
   public String toString() {
      String stationStr = this.name + " (";
      
      // add latitude:
      if (this.latitude < 0) {
         // negative latitude --> southern hemisphere
         stationStr += Math.abs(this.latitude) + "°S, ";
      } else {
         // positive latitude --> northern hemisphere
         stationStr += this.latitude + "°N, ";
      }

      if (this.longitude < 0) {
         // negative longitude --> western hemisphere
         stationStr += Math.abs(this.longitude) + "°W)";
      } else {
         // positive longitude --> eastern hemisphere
         stationStr += this.longitude + "°E)";
      }
      return stationStr;
   }
}
