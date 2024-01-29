class Solution {
    
    int[] ryan = new int[11];
    int[] apeach;
    int apeachScore;
    
    int maxDiff = 0;        
    
    int[] answer;
    
    public int[] solution(int n, int[] info) {
        
        //initialize
        apeach = info;
        apeachScore = 0;
        
        //어피치의 최고점 계산
        for(int idx = 0; idx <= 10; idx++){
            apeachScore += (apeach[idx] > 0) ? (10-idx) : 0;    //과녁을 맞췄으면 득점
        }
        
        dfs(0, n, -apeachScore);
        
        if(answer == null){
            return new int[] {-1};
        }
                
        return answer;
    }
    
    public void dfs(int idx, int remain, int scoreDiff){
        /*
            idx: info의 index
            remain: 남은 화살 개수
            scoreDiff: 어피치-라이언
        */
        
        if(remain < 0 || idx == 11){
            return;
        }
        if(idx == 10){  //0점에 재고 떨이
            ryan[idx] = remain;
            remain = 0;
        }
        if(remain == 0){
            isAnswer(scoreDiff);
        }
        
        //라이언이 (10-idx)점을 득점한 경우
        int cnt = apeach[idx] + 1;
        ryan[idx] = cnt;
        dfs(idx+1, remain - cnt, calcDiff(idx, scoreDiff));
        
        //얻지 못한 경우
        ryan[idx] = 0;
        dfs(idx+1, remain, scoreDiff);
        
    }
    
    public int calcDiff(int idx, int scoreDiff){
        if(apeach[idx] == 0){   //어피치가 기존에 맞히지 못했던 점수
            return scoreDiff + (10-idx);
        }
        else{   //어피치가 기존에 맞혔던 점수
            return scoreDiff + (10-idx) * 2;
        }
    }
    
    public void isAnswer(int scoreDiff){
        if(scoreDiff > maxDiff){
            maxDiff = scoreDiff;
            answer = ryan.clone();
        }
        else if(scoreDiff == maxDiff && scoreDiff != 0){ //후자는 라이언의 우승에 대한 조건
            for(int idx = 10; idx >= 0; idx--){
                if(ryan[idx] > answer[idx]){
                    answer = ryan.clone();
                    break;
                }
                else if(ryan[idx] < answer[idx]){
                    break;
                }
            }
        }
    }
}