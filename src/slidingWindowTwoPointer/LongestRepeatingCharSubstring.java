package slidingWindowTwoPointer;

public class LongestRepeatingCharSubstring {
    public int characterReplacement(String s, int k) {
        int[] hash=new int[26];
        int l=0, r=0, maxL=0, maxFreq=0;
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq, hash[s.charAt(r)-'A']);
            while((r-l+1)-maxFreq>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxL=Math.max(maxL, r-l+1);
            r++;
        }
        return maxL;
    }
}
