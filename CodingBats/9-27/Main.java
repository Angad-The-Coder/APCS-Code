class Main {
    public static void main(String args[]) {
        System.out.println("left2(\"Hello\") " + left2("Hello"));
        System.out.println("makeTags(\"i\", \"Yay\") " + makeTags("i", "Yay"));
        System.out.println("minCat(\"Hello\", \"Hi\") " + minCat("Hello", "Hi"));
        System.out.println("countCode(\"aaacodebbb\") " + countCode("aaacodebbb"));
        System.out.println("countHi(\"abc hi ho\") " + countHi("abc hi ho"));
        System.out.println("repeatSeparator(\"Word\", \"X\", 3) " + repeatSeparator("Word", "X", 3));
    }

    public static String left2(String str) {
        return str.substring(2) + str.substring(0, 2);
    }

    public static String makeTags(String tag, String word) {
        return "<" + tag + ">" + word + "</" + tag + ">";
    }

    public static String minCat(String a, String b) {
        int minLength = a.length() < b.length() ? a.length() : b.length();
        return a.substring(a.length() - minLength) + b.substring(b.length() - minLength);
    }

    public static int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            String fourSlice = str.substring(i, i + 4);
            if (fourSlice.substring(0, 2).equals("co") && fourSlice.substring(3).equals("e")) {
                count++;
            }
        }
        return count;
    }

    public static int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            String twoSlice = str.substring(i, i + 2);
            if (twoSlice.equals("hi"))
                count++;
        }
        return count;
    }

    public static String repeatSeparator(String word, String sep, int count) {
        if (count == 0)
            return "";
        String repeated = word;
        for (int i = 0; i < count - 1; i++) {
            repeated += sep + word;
        }
        return repeated;
    }
}
