package slidingWindowTwoPointer;
import java.util.*;
public class LongestSubstringKDistinctCharacters {
    public int kDistinctChar(String s, int k) {
        //your code goes here
        // Set<Character> set=new HashSet();
        Map<Character, Integer> m=new HashMap();

        int l=0, r=0, maxLen=0;
        while(r<s.length()){
            m.put(s.charAt(r), m.getOrDefault(s.charAt(r), 0)+1);
            while(m.size()>k){
                char leftChar=s.charAt(l);
                if(m.get(leftChar)==1){
                    m.remove(leftChar);
                }
                else{
                    m.put(leftChar, m.get(leftChar)-1);
                }
                l++;
            }
            maxLen=Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }}
