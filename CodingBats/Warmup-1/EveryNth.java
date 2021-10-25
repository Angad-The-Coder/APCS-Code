public class EveryNth {
    /**
     * https://codingbat.com/prob/p196441
     * 
     * Given a non-empty string and an int N, return the string made starting with char 0, and then
     * every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.
     * 
     * everyNth("Miracle", 2) → "Mrce"
     * everyNth("abcdefg", 2) → "aceg"
     * everyNth("abcdefg", 3) → "adg"
     */

    // Solution to prompt:
    public String everyNth(String str, int n) {
        String everyNthStr = "";
        // iterate through str, incrementing the index by n:
        for (int i = 0; i < str.length(); i += n) {
            // concatenate the character at index i in str with everyNthStr:
            everyNthStr += str.substring(i, i+1);
        }
        return everyNthStr;
    }
}
