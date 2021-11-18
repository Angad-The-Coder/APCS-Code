/* Represents a weather observation */
public class Observation {
   // unset Strings will be null by default; set floats to be Float.MIN_VALUE so I can later check
   // which variables have been set or not
   private String location;
   private String description;
   private float temp = Float.MIN_VALUE; // fahrenheit
   private float windSpeed = Float.MIN_VALUE; // mph
   private float dewPoint = Float.MIN_VALUE; // farenheit
   private float humidity = Float.MIN_VALUE; // percent


   Observation(String location, float temp, float windSpeed) {
      this.location = location;
      this.temp = temp;
      this.windSpeed = windSpeed;
   }

   Observation(String location, float temp, float windSpeed, String description, float dewPoint,
         float humidity) {
      this.location = location;
      this.temp = temp;
      this.windSpeed = windSpeed;
      this.dewPoint = dewPoint;
      this.humidity = humidity;
      this.description = description;
   }

   /* determine if the temperature of this observation is colder than 'that's */
   public boolean colderThan(Observation that) {
      return this.temp < that.getTemp();
   }

   /* determine if the humidity of this observation is greater than 'that's */
   public boolean moreHumidThan(Observation that) {
      return this.humidity > that.getHumidity();
   }

   /* determine if the dew point of this observation is greater than 'that's */
   public boolean higherDewPointThan(Observation that) {
      return this.dewPoint > that.getDewPoint();
   }

   /**
    * Compares this Observation with the input Observation according to wind speed
    * 
    * @param in the Observation to be compared to
    * @return a value less than 0 if the input Observation is windier than this and a value greater
    *         than 0 if this is windier than the specified Observation and returns 0 if they have
    *         the same wind speed.
    */
   public float compareTo(Observation in) {
      return this.windSpeed - in.getWindSpeed();
   }

   /* produce a string describing this observation */
   public String toString() {
      String observationStr = "";

      // add all variables that have been set to the final string:
      if (this.location != null)
         observationStr += this.location + ":\n";
      if (this.description != null)
         observationStr += " - Weather: " + this.description + "\n";
      if (this.temp != Float.MIN_VALUE)
         observationStr += " - Temperature: " + this.temp + "°F\n";
      if (this.windSpeed != Float.MIN_VALUE)
         observationStr += " - Wind Speed: " + this.windSpeed + "mph\n";
      if (this.dewPoint != Float.MIN_VALUE)
         observationStr += " - Dew point: " + this.dewPoint + "°F\n";
      if (this.humidity != Float.MIN_VALUE)
         observationStr += " - Relative Humidity: " + this.humidity + "%\n";

      return observationStr;
   }

   /* Getters */

   public float getTemp() {
      return this.temp;
   }

   public float getWindSpeed() {
      return this.windSpeed;
   }

   public float getDewPoint() {
       return this.dewPoint;
   }

   public float getHumidity() {
       return this.humidity;
   }
}
