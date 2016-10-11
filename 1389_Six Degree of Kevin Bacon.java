import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 8.
 * BOJ 1389 6-degrees of Kevin Bacon
 */
public class Main {
	
	
	
	/**
	 * Graph, BFS using Queue
	 * 
	 * member
	 * - Graph Array[n][n]
	 * - visit array[n]
	 * - result degree array[n]
	 * - result degree Sum array[n]
	 * - queue array
	 * 
	 * method
	 * - set Friend
	 * - constructor
	 * - find
	 * - clear
	 * - sum
	 * - enqueue
	 * - dequeue
	 * 
	 * 개선할점
	 *  중복탐색이 너무 많다.
	 *  ex) 1번 user의 친구단계 검색후  n번 친구와의 관계가 확정되면
	 *  	n번 user의 친구단계 검색시 1번 친구와의 관계를 구할 필요가없는데...
	 * 
	 */
	boolean[][] graph;
	boolean[] visit;
	int[] resultDegree;
	int minimumValue;
	int minimumUserName;
	int N;
	
	int [] queue;
	int qFirst, qLast;
	
	private void enqueue(int userName){
		qLast++;
		queue[qLast] = userName;
	}
	private int dequeue(){
		
		
		if( !isQueueEmpty()){
			int item = queue[qFirst];
			qFirst++;
			return item;
		}
		
		return -1;
	}
	
	private int getQueueSize(){
		return qLast-qFirst;
	}
	
	private boolean isQueueEmpty(){
		if( getQueueSize () < 0)
			return true;
		return false;
					
	}

	private Main(int N){
		graph = new boolean[N][N];
		visit = new boolean[N];
		resultDegree = new int[N];
		minimumValue = -1;
		this.N = N;
		
		queue = new int[N];
		qFirst = 0;
		qLast = -1;
	}
	
	private void setFriend(int user1, int user2){
		graph[user1][user2] = true;
		graph[user2][user1] = true;
	}
	
	
	private void find(int userName){
		
		/*
		 *  1 userName visit check
		 *  2 graph 비교해서 연결되어 있으면 visit &  result에  count 기록 & find(그 친구, ++count)
		 */
		
		visit[userName] = true;
		enqueue(userName);
		
		
		resultDegree[userName] = 1;
		
		int count = 1;
		int visitCount = 0;
		int whileCount = 1;
		
		
		while( !isQueueEmpty()){
						
			while( (whileCount = whileCount-1) >= 0  ) {
			
				userName = dequeue();
				
				for(int i = 0; i < N ; i++){
					if(graph[userName][i] && !visit[i]){
						visit[i] = true;
						enqueue(i);
						resultDegree[userName] = count;
						visitCount++;
					}
				}
			}
			whileCount = visitCount;
			visitCount = 0;
			count++;
			
		}
		
		
	}
	
	private void clear(){
		for(int i = 0 ; i < N ; i ++){
			visit[i] = false;
			resultDegree[i] = 0;
		}
		qFirst = 0;
		qLast = -1;
		
	}
	private int sum(){
		int sum = 0;
		for(int i = 0 ; i < N ; i++){
			sum += resultDegree[i];
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		Scanner sc = new Scanner(System.in);
		
		PrintWriter pw = new PrintWriter(System.out);
		BufferedWriter bw = new BufferedWriter(pw);
		
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Main KB = new Main(N);
		
		int user1;
		int user2;
		
		for(int i=0 ; i<M ; i++){
			user1 = (sc.nextInt() - 1);
			user2 = (sc.nextInt() - 1);
			KB.setFriend(user1, user2);
		}
		
		for(int i = 0 ; i < N ; i++){
			KB.find(i);
			if (KB.minimumValue > KB.sum() || KB.minimumValue == -1 ){
				KB.minimumValue = KB.sum();
				KB.minimumUserName = (i+1);
			}
			KB.clear();
		}
		
		
		
		System.out.print(KB.minimumUserName);
		
		
	}
}