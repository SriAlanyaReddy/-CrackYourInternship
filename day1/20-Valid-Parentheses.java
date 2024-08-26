import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // If the stack is empty or the brackets don't match, return false
                if (stack.isEmpty() || 
                    (c == '}' && stack.peek() != '{') ||
                    (c == ')' && stack.peek() != '(') ||
                    (c == ']' && stack.peek() != '[')) {
                    return false;
                }
                // Otherwise, pop the stack
                stack.pop();
            }
        }
        
        // If the stack is empty, all brackets were matched, so return true
        return stack.isEmpty();
    }
}

