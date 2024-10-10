import java.util.*;
class Solution {
    static List<String> madeWords = new ArrayList<>();
    static String[] vowels = new String[]{"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 0;
        
        
        
        for (int i=0; i<vowels.length; i++){
            makeWord(vowels[i]);
        }
        
        Collections.sort(madeWords, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        
        return madeWords.indexOf(word)+1;
    }
    public void makeWord(String word){
        if (!madeWords.contains(word)) madeWords.add(word);
        
        if (word.length()==5) return;
        for (int i=0; i<vowels.length; i++){
            makeWord(word+vowels[i]);
        }
    }
}