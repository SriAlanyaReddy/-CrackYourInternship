/*Mr Ajay Sharma is working woth words.
He found that few words in the langugage have same meaning.
Such words are given as a list of pairs as mappedpairs[],
where mappedpairs[i] = [word1, word2] indicates that word1 and word2 are 
the words with same meaning.

He is given phrase, and he wants to apply all the mappedpairs[] on the phrase.

Your task is to help Mr.Ajay Sharma to find and return all possible 
Mapped Phrases generated after applying all the mapped words,
and print them in lexicographical order.


Input Format:
-------------
Line-1: An integer N, number of mapped pairs.
Next N lines: Two space separated words, mappedpair[].
Last Line: A line of words, the phrase.

Output Format:
--------------
Print the list of mapped phrases in sorted order.


Sample Input-1:
---------------
3
hi hello
sweet sugar
candy chocolate
hi sam! ram has a sugar candy

Sample Output-1:
----------------
[hello sam! he has sugar candy, hello sam! he has sugar chocolate, 
hello sam! he has sweet candy, hello sam! he has sweet chocolate, 
hi sam! he has sugar candy, hi sam! he has sugar chocolate, 
hi sam! he has sweet candy, hi sam! he has sweet chocolate]



Sample Input-2:
---------------
2
hi hey
hey hello
hi how are you

Sample Output-2:
----------------
[hello how are you, hey how are you, hi how are you]*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, List<String>> map = new HashMap<>();

         for (int i = 0; i < n; i++) {
            String[] pair = sc.nextLine().split(" ");
            addToMap(map, pair[0], pair[1]);
            addToMap(map, pair[1], pair[0]);
        }

        
        String phrase = sc.nextLine();

        List<String> result = generatePhrases(map, phrase);
        System.out.println(result);
    }

   
    private static void addToMap(HashMap<String, List<String>> map, String word1, String word2) {
        map.putIfAbsent(word1, new ArrayList<>());
        map.get(word1).add(word2);
    }

   
    private static List<String> generatePhrases(HashMap<String, List<String>> map, String phrase) {
        Queue<String> queue = new LinkedList<>();
        Set<String> resultSet = new TreeSet<>();


        queue.add(phrase);

        while (!queue.isEmpty()) {
            String currentPhrase = queue.poll();

            resultSet.add(currentPhrase);

            String[] words = currentPhrase.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i])) {
                    for (String synonym : map.get(words[i])) {
                         words[i] = synonym;
                        String newPhrase = String.join(" ", words);
                        if (!resultSet.contains(newPhrase)) {
                            queue.add(newPhrase);
                        }
                    }
                }
            }
        }

    
        return new ArrayList<>(resultSet);
    }
}
