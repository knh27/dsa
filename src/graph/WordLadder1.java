package graph;
import java.util.*;

public class WordLadder1 {
    class Pair{
        String word;
        int len;
        Pair(String word, int len){
            this.word=word;
            this.len=len;
        }
    }
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        Set<String> st=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            st.add(wordList[i]);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord, 1));

        while(!q.isEmpty()){
            Pair temp=q.poll();
            String word=temp.word;
            int len=temp.len;
            if(word.equals(targetWord)){
                return len;
            }
            for(int i=0;i<word.length();i++){
                char[] wordArr=word.toCharArray();//string to character array
                char org=wordArr[i];

                for(char ch='a'; ch<='z';ch++){
                    wordArr[i]=ch;
                    String newWord=new String(wordArr);
                    if(st.contains(newWord)){
                        q.add(new Pair(newWord, len+1));
                        st.remove(newWord);
                    }
                }
                wordArr[i]=org;
            }
        }
        return 0;
    }
}
