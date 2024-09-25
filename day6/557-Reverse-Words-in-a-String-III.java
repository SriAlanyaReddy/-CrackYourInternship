class Solution {
    public String reverseWords(String s) {
        // Split the input string by spaces into an array of words
        String[] words = s.split(\ \);
        StringBuilder result = new StringBuilder();

        // Loop through each word in the array
        for (String word : words) {
            // Reverse the current word
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            
            // Append the reversed word to the result with a space
            result.append(reversedWord.toString()).append(\ \);
        }

        // Convert StringBuilder to string and trim the trailing space
        return result.toString().trim();
    }
}
