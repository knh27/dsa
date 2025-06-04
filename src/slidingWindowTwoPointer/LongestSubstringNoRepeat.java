package slidingWindowTwoPointer;

public class LongestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, len=0,maxLen=0;
        int[] hash=new int[256];
        for(int i=0;i<256;i++)hash[i]=-1;
        while(r<s.length()){
            if((hash[s.charAt(r)] != -1) && (hash[s.charAt(r)]>=l)){
                l=hash[s.charAt(r)]+1;

            }
            len=r-l+1;
            hash[s.charAt(r)]=r;
            maxLen=Math.max(len, maxLen);
            r++;
        }
        return maxLen;

    }
}

