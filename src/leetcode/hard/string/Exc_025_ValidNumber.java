package leetcode.hard.string;

public class Exc_025_ValidNumber {

    public boolean isNumber(String s) {
        if (!validChar(s)) return false;
        if (s.startsWith("e") || s.endsWith("e") || s.startsWith("E") || s.endsWith("E")) {
            return false;
        }
        if (s.startsWith("+") || s.startsWith("-")) {
            return isUnsignedNumber(s.substring(1));
        }
        return isUnsignedNumber(s);
    }

    private boolean isUnsignedNumber(String s) {
        if (s.startsWith("+") || s.startsWith("-")) return false;
        if (s.contains("e") || s.contains("E")) {
            int i = s.indexOf("e");
            if (i == -1)
                i = s.indexOf("E");
            String left = s.substring(0, i);
            if (left.length() == 0) return false;
            String right = s.substring(i + 1);
            if (right.startsWith("+") || right.startsWith("-")) {
                right = right.substring(1);
            }
            if (right.length() == 0) return false;
            if (!isFloatOrInteger(left) || !isInteger(right))
                return false;
            else
                return true;
        }
        else if (s.contains(".")) {
            return isFloatOrInteger(s);
        }
        else
            return isInteger(s);
    }

    private boolean isFloatOrInteger(String s) {
        if (!s.contains(".")) return isInteger(s);
        int i = s.indexOf(".");
        String left = s.substring(0, i);
        String right = s.substring(i + 1);
        if (left.length() == 0 && right.length() == 0)
            return false;
        return isInteger(left) && isInteger(right);
    }

    private boolean isInteger(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    private boolean validChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= '0' && c <= '9' || c == '-' || c == '+' || c == 'e' || c == '.' || c == 'E')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Exc_025_ValidNumber vn = new Exc_025_ValidNumber();
//        System.out.println(vn.isNumber("0089"));  // true
//        System.out.println(!vn.isNumber("e3"));    // false
//        System.out.println(!vn.isNumber("99e2.5")); // false
//        System.out.println(!vn.isNumber("--6")); // false
//        System.out.println(!vn.isNumber("abc")); // false
//        System.out.println(!vn.isNumber("95a54e53")); // false
//        System.out.println(vn.isNumber("-123.456e789")); // true
//        System.out.println(vn.isNumber("-90E3")); // true
//        System.out.println(vn.isNumber("+6e-1")); // true
//        System.out.println(vn.isNumber("+3.14")); // true
//        System.out.println(vn.isNumber("4.")); // true
//        System.out.println(vn.isNumber("53.5e93")); // true
//        System.out.println(!vn.isNumber("53.5e93e3")); // false
//        System.out.println(!vn.isNumber(".")); // false
//        System.out.println(!vn.isNumber("e")); // false
//        System.out.println(vn.isNumber(".1")); // true
//        System.out.println(vn.isNumber("4e+"));
        System.out.println(vn.isNumber("+E3"));
    }
}
