public class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] word1a = word1.toCharArray();
        char[] word2a = word2.toCharArray();
        char[] wordab = new char[word1a.length + word2a.length];
        
        int index1 = 0, index2 = 0;
        for (int i = 0; i < wordab.length; i++) {
            if (i % 2 == 0 && index1 < word1a.length) {
                wordab[i] = word1a[index1++];
            } else if (index2 < word2a.length) {
                wordab[i] = word2a[index2++];
            }
        }
        return new String(wordab);
    }
}
