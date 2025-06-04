package greedyAlgorithms;
import java.util.*;

public class AssignCookiesToChildren {
    public int findContentChildren(int[] g, int[] s) {
        int greed = 0, cookie = 0, count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (greed < g.length && cookie < s.length) {
            if (s[cookie] >= g[greed]) {
                count++;
                greed++;
            }
            cookie++;
        }
        return count;
    }
}
