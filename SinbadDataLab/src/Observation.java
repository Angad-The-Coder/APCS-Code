/* Represents a weather observation */
public class Observation {
    private float temp;    // in fahrenheit
    private int windDir;   // in degrees
    private String description;
    
    
    Observation(String description, float temp, int windDir) {
 
    }
    
    /* determine if the temperature of this observation is colder than 'that's */
    public boolean colderThan(Observation that) {
       return false;
    }
    /**
     * Compares this Observation with the input Observation according to wind speed
     * @param in the Observation to be compared to
     * @return a value less than 0 if the input Observation is windier than this and
     * a value greater than 0 if this is windier than the specified Observation and 
     * returns 0 if they have the same wind speed.
     */
    public int compareTo(Observation in){
       return 0;
    }
 
    /* produce a string describing this observation */
    public String toString() {
       return null;
    }
 }
