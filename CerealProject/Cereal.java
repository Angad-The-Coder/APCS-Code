public class Cereal implements Comparable<Cereal> {

    // Look at the output in the Console. We need a field for each attribute of a Cereal
    private String name;
    private boolean cold;
    private int calories;

    // our constructor(s) should reflect the private instance variables that we use


    // add getters (do we need setters?)

    /**
     * This method inputs a String that represents a Cereal Object and converts the
     * 
     * @param s
     * @return
     */
    public static Cereal parseCereal(String s) {

        return null;
    }

    @Override
    public String toString() {
        String s = "";// add lots of stuff to the String!


        return s;
    }


    /*
     * We want to use a strategy similar to the StringFreq class we created In that class, we had an
     * int that we used to determine the attribute that we would use to compare a Cereal with
     * another Cereal.
     * 
     */
    public int compareTo(Cereal arg0) {

        return 0;
    }

}
