
class Solution {
    public String solution(String s) {
        
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if(i == 0 || s.charAt(i-1) == ' '){ //첫 글자
                if( 97 <= c && c <= 122){
                    sb.setCharAt(i, (char)(c-32));
                }
            }            
        }
                
        return sb.toString();
    }
}