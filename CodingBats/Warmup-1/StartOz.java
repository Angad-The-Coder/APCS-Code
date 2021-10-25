public class StartOz {
    /**
     * https://codingbat.com/prob/p199720
     * 
     * Given a string, return a string made of the first 2 chars (if present), however include first
     * char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".
     * 
     * startOz("ozymandias") → "oz"
     * startOz("bzoo") → "z"
     * startOz("oxx") → "o"
     */

    // Solution to prompt:
    public String startOz(String str) {
        String ozStr = "";
        // check that str's length is >= 1 to prevent an out of bound's error:
        if (str.length() >= 1 && str.substring(0, 1).equals("o")) {
            ozStr += "o";
        }
        // check that str's length is >= 2 to prevent an out of bound's error:
        if (str.length() >= 2 && str.substring(1, 2).equals("z")) {
            ozStr += "z";
        }
        return ozStr;
    }
}
