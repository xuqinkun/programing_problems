package newcode.swordtooffer;

public class StringOp {


    /**
     *
     * 当模式中的第二个字符不是“*”时：
     * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
     * 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
     *
     * 而当模式中的第二个字符是“*”时：
     * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
     * 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
     * 1、模式后移2字符，相当于x*被忽略；
     * 2、字符串后移1字符，模式后移2字符；
     * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) return false;
        int strIndex = 0, patternIndex = 0;
        return matchCore(str, pattern, strIndex, patternIndex);
    }

    private boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
        if (strIndex > str.length || patternIndex > pattern.length) return false;
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        // 当模式中的第二个字符不是“*”时：
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] != '*') {
            // 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
            if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
                return matchCore(str, pattern, strIndex + 1, patternIndex + 1);
            } else {  // 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
                return false;
            }
        }
        // 而当模式中的第二个字符是“*”时：
        else if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 如果字符串第一个字符与模式第一个字符不匹配，则模式后移一个字符
            if (strIndex != str.length && str[strIndex] != pattern[patternIndex] && pattern[patternIndex] != '.') {
                return matchCore(str, pattern, strIndex, patternIndex + 2);
            } else { // 如果字符串第一个字符与模式第一个字符相匹配，则分三种情况
                return matchCore(str, pattern, strIndex, patternIndex + 2) ||
                        matchCore(str, pattern, strIndex + 1, patternIndex + 2) ||
                        matchCore(str, pattern, strIndex + 1, patternIndex);
            }
        }
        if (strIndex != str.length &&
                (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
            return matchCore(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        StringOp op = new StringOp();
        char[] str = "a".toCharArray();
        char[] pattern = "ab*a".toCharArray();
        System.out.println(op.match(str, pattern));
    }
}
