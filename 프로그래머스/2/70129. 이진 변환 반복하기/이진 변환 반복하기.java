import java.util.*;

class Solution {
    public int[] solution(String s) {

        int trans = 0;
        int removed0 = 0;
        
        while(!s.equals("1")){            
            trans++;
            
            String newS = s.replaceAll("0", "");            //모든 0 제거
            removed0 += s.length() - newS.length();
            s = Integer.toString(newS.length(), 2);      //이진변환            
        }
                
        return new int[]{trans, removed0};
    }
}