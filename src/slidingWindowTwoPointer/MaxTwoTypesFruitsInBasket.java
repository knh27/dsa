package slidingWindowTwoPointer;
import java.util.*;

public class MaxTwoTypesFruitsInBasket {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> m = new HashMap();
        int l = 0, r = 0, maxLen = 0;
        while (r < fruits.length) {
            m.put(fruits[r], m.getOrDefault(fruits[r], 0) + 1);
            while (m.size() > 2) {
                if (m.get(fruits[l]) == 1) {
                    m.remove(fruits[l]);
                } else {
                    m.put(fruits[l], m.get(fruits[l]) - 1);
                }

                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
