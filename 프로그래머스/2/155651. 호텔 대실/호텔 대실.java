import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        int[][] reservation = toMinute(book_time);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]); //대실 종료 시각 기준 오름차순 정렬
        
        int answer = 1;
        for(int[] r : reservation){
            
            if(!q.isEmpty()){
                if(r[0] >= q.peek()[1]){    //가장 빠른 대실 종료시각이 대실 시작시간보다 전이라면
                    q.remove();     //대실 종료
                }
                else{
                    answer++;       //방 추가
                }
            }
            q.add(r);            //입실
        }
        
        return answer;
    }
    
    public int[][] toMinute(String[][] book_time){
        
        int[][] times = new int[book_time.length][2];       //[대실 시작시각, 대실 종료시각]
        for(int i = 0; i < book_time.length; i++){
            
            //대실 시작시각
            times[i][0] = Integer.parseInt(book_time[i][0].substring(0,2)) * 60 + Integer.parseInt(book_time[i][0].substring(3));
            //대실 종료 시각
            times[i][1] = Integer.parseInt(book_time[i][1].substring(0,2)) * 60 + Integer.parseInt(book_time[i][1].substring(3)) + 10;            
        }
        
        Arrays.sort(times, (a,b) -> a[0]-b[0]);

        return times;        
    }
}