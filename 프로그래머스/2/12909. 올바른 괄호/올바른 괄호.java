import java.util.*;     //for using 'Stack'

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(stk.empty()){
                stk.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ')' && stk.peek() == '('){
                stk.pop();
                continue;
            }
            stk.push(s.charAt(i));
        }
        
        return stk.empty();
    }
}