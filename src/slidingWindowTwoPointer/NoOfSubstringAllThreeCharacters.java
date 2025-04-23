package slidingWindowTwoPointer;
import java.util.*;
public class NoOfSubstringAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, c = 0;
        Map<Character, Integer> m = new HashMap<>();

        while (r < s.length()) {
            m.put(s.charAt(r), m.getOrDefault(s.charAt(r), 0) + 1);

            while (m.size() == 3) {
                c += (s.length() - r); // count valid substrings

                // shrink window from the left
                char leftChar = s.charAt(l);
                m.put(leftChar, m.get(leftChar) - 1);
                if (m.get(leftChar) == 0) {
                    m.remove(leftChar);
                }
                l++;
            }
            r++;
        }

        return c;
    }
}
