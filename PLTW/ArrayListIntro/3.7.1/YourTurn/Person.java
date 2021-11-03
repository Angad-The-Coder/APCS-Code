public class Person {
    /* Instance Variables */
    private String name;
    private int age;
    private boolean wearsGlasses;

    /* Constructor */
    public Person(String name, int age, boolean wearsGlasses) {
        this.name = name;
        this.age = age;
        this.wearsGlasses = wearsGlasses;
    }

    /* toString */
    public String toString() {
        String personStr = "";
        // give person an face based on whether they wear glasses or not:
        if (this.wearsGlasses) {
            personStr += "(■_■) ";
        } else {
            personStr += "(o_o) ";
        }
        // include the person's age and name (ex. "37 year old Mark Zuckerberg")
        personStr += this.age + " year old " + this.name;

        return personStr;
    }
}
