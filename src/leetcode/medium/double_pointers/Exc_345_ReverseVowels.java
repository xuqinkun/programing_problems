package leetcode.medium.double_pointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exc_345_ReverseVowels {
    private Set<Character> vowels = new HashSet<>();
    {
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        vowels.addAll(Arrays.asList('A', 'E', 'I', 'O', 'U'));
    }
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char ci = chars[i], cj=chars[j];
            if (vowels.contains(ci) && vowels.contains(cj)) {
                chars[i] = cj;
                chars[j] = ci;
                i++;
                j--;
            } else if (vowels.contains(ci) && !vowels.contains(cj)) {
                j--;
            } else {
                i++;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Exc_345_ReverseVowels rv = new Exc_345_ReverseVowels();
        System.out.println(rv.reverseVowels("IceCreAm"));
        System.out.println(rv.reverseVowels("leetcode"));
        System.out.println(rv.reverseVowels("apple"));
    }
}
