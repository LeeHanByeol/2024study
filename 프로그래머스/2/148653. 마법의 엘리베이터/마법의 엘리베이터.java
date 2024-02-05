class Solution {
    
    public int solution(int storey) {
    
        int answer = 0;
        
        int former = 0;     //뒤에서 2번째 자리
        int number = 0;     //뒤에서 1번째 자리
        
        while(storey != 0){
            former = (storey / 10) % 10;
            number = storey % 10;
            
            if(number <= 4 || (number == 5 && former <= 4)){
                answer += number;
            }
            else{
                answer += (10-number);
                storey += 10;           //올림
            }
            
            storey /= 10;
        }
        
        return answer;
    }
    
}
