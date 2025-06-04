package graph;
import java.util.*;
public class WordLadder2 {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        Queue<ArrayList<String>> q=new LinkedList<>();
        Set<String> st=new HashSet<>();

        for(String s:wordList)st.add(s);

        ArrayList<String> l=new ArrayList<>();
        l.add(startWord);
        q.add(l);

        ArrayList<String> usedLevels=new ArrayList<>();//***
        usedLevels.add(startWord);
        int level=0;

        ArrayList<ArrayList<String>> ans=new ArrayList<>();

        while(!q.isEmpty()){
            ArrayList<String> tempList=q.poll();
            int size=tempList.size();

            if(size>level){ //***
                level++;
                for(String s:usedLevels){
                    st.remove(s);
                }
            }

            String word=tempList.get(size-1);

            if(word.equals(targetWord)){ //*** only adding shortest paths
                if(ans.size()==0)ans.add(tempList);
                else if(ans.get(0).size()==tempList.size())ans.add(tempList);
            }

            for(int i=0;i<word.length();i++){
                char[] wordArr=word.toCharArray();
                char orgCh=wordArr[i];
                for(char ch='a'; ch<='z'; ch++){
                    wordArr[i]=ch;
                    String newWord=new String(wordArr);
                    if(st.contains(newWord)){
                        ArrayList<String> newL=new ArrayList<>();
                        newL.addAll(tempList);
                        newL.add(newWord);

                        usedLevels.add(newWord);//***
                        // tempList.remove(tempList.size()-1);
                        q.add(newL);
                    }
                }
                wordArr[i]=orgCh;

            }

        }
        return ans;

    }
}
