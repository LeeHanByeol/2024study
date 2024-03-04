import java.util.*;

class Solution {
    
    LinkedList<Node>[] adjNodes;        //인접노드 정보 배열
    
    class Node implements Comparable<Node> {
        
        int num;
        int cost;
        
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;   
        }
    }    
    
    public int solution(int N, int[][] road, int K) {
        
        adjNodes = new LinkedList[N+1];
        for(int i = 1; i <= N; i++){
            adjNodes[i] = new LinkedList<>();
        }
        
        //인접 노드 배열 
        for(int i = 0; i < road.length; i++){
            int startV = road[i][0];
            int endV = road[i][1];
            int cost = road[i][2];
            
            adjNodes[startV].add(new Node(endV, cost));
            adjNodes[endV].add(new Node(startV, cost));
        }
        
        return dijkstra(N, K);
        // return 1;
    }
    
    public int dijkstra(int N, int K){
        
        //initialize        
        boolean[] check = new boolean[N+1];     //각 마을의 방문 여부
        int[] distance = new int[N+1];          //1번 마을에서 각 마을까지의 최소 거리
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;            //1번 마을에서 시작하므로 0
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        
        while(!pq.isEmpty()){
            
            int now = pq.poll().num;
            
            if(check[now]){   //방문한 적이 있는 노드라면,
                continue; 
            }

            //방문한 적이 없는 노드라면,
            check[now] = true;    //방문 처리
            for(Node next : adjNodes[now]){   //now의 인접노드 하나씩 살펴봄
                if(distance[next.num] > distance[now] + next.cost){
                    distance[next.num] = distance[now] + next.cost;
                    pq.add(new Node(next.num, distance[next.num]));
                }             
            }            
        }
        
        //K시간 이하가 걸리는 마을 개수 구하기
        int answer = 0;
        for(int dist : distance){
            answer += (dist <= K) ? 1 : 0;
        }
        return answer;
    }
}