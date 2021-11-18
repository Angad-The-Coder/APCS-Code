import core.data.*;

public class ProcessWeatherStationObject {
   public static void main(String[] args) {
      ProcessWeatherStationObject pwo = new ProcessWeatherStationObject();
      // pwo.test3ParamConstructor();
      pwo.test6ParamConstructor();
   }

   private void test3ParamConstructor() {
      String id1 = "KATL";
      DataSource ds1 = DataSource.connect("http://weather.gov/xml/current_obs/" + id1 + ".xml");
      ds1.setCacheTimeout(15 * 60);
      ds1.load();
      ds1.printUsageString();

      Observation ob1 = ds1.fetch("Observation", "location", "temp_f", "wind_mph");
      System.out.println(id1 + ": " + ob1);

      String id2 = "KSAV";
      DataSource ds2 = DataSource.connect("http://weather.gov/xml/current_obs/" + id2 + ".xml");
      ds2.setCacheTimeout(15 * 60);
      ds2.load();

      Observation ob2 = ds2.fetch("Observation", "location", "temp_f", "wind_mph");
      System.out.println(id2 + ": " + ob2);

      if (ob1.colderThan(ob2)) {
         System.out.println("Colder at " + id1);
      } else {
         System.out.println("Colder at " + id2);
      }
      if (ob1.compareTo(ob2) < 0) {
         System.out.println("Windier at " + id2);
      } else if (ob1.compareTo(ob2) > 0) {
         System.out.println("Windier at " + id1);
      } else {
         System.out.println("Same windiness at both");
      }
   }

   /**
    * This method will require you to create a NEW constructor in the Observation class. Classes can
    * have as many constructors as they need. The only requirement is that the parameter lists
    * cannot be the same (because the compiler would not know which to call). Update the toString
    * method Then, provide getters so that the Observations can be compared based on the new
    * attributes.
    */
   private void test6ParamConstructor() {
      String id1 = "KATL";
      DataSource ds1 = DataSource.connect("http://weather.gov/xml/current_obs/" + id1 + ".xml");
      ds1.setCacheTimeout(15 * 60);
      ds1.load();

      // ds1.printUsageString();

      // I added an argument. You need to add two more arguments for the line below.
      // Finally, add another constructor in the Observation class below so that the line below
      // will execute.
      Observation ob1 = ds1.fetch("Observation", "location", "temp_f", "wind_mph", "weather", "dewpoint_f", "relative_humidity");
      System.out.println(id1 + ": " + ob1);

      String id2 = "KSAV";
      DataSource ds2 = DataSource.connect("http://weather.gov/xml/current_obs/" + id2 + ".xml");
      ds2.setCacheTimeout(15 * 60);
      ds2.load();

      Observation ob2 = ds2.fetch("Observation", "location", "temp_f", "wind_mph", "weather", "dewpoint_f", "relative_humidity");
      System.out.println(id2 + ": " + ob2);

      // Now compare based on the new attributes that we added
      if (ob1.moreHumidThan(ob2)) {
         System.out.println("More humid at " + id1);
      } else {
         System.out.println("More humid at " + id2);
      }
      if (ob1.higherDewPointThan(ob2)) {
         System.out.println(id1 + " has a higher dew point.");
      } else {
         System.out.println(id2 + " has a higher dew point.");
      }

   }

}
