import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author HOON
 * @date   2016. 10. 14.
 * BOJ 1260 DFS & BFS  
 */
public class Main {
	
	static int N;
	static int M;
	
	static BufferedWriter bw; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new PrintWriter(System.out));
		
		
		boolean[][] graph;
		boolean[] visit;
		
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		
		
		graph = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		
		int a;
		int b;
		for(int i=0 ; i<M ; i++){
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		DFS(graph, visit, stack, start);
		bw.newLine();
		Arrays.fill(visit, false);
		BFS(graph, visit, queue, start);
		
		bw.flush();
		
	}
	
	static void BFS(boolean[][] graph, boolean[] visit, Queue<Integer> queue, int start) throws IOException{
		
		visit[start] = true;
		queue.offer(start);
		
		int vertex;
		while(!queue.isEmpty()){
			vertex = queue.poll();
			bw.write(String.valueOf(vertex) + " ");
			for(int i=1 ; i<=N ; i++){
				
				if(graph[vertex][i] && !visit[i]){
					visit[i] = true;
					queue.offer(i);
				}
				
			}
		}
		
	}
	
	static void DFS(boolean[][] graph, boolean[] visit, Stack<Integer> stack, int start) throws IOException{
		
		visit[start] = true;
		stack.push(start);
		
		boolean[] print = new boolean[N+1];
		
		int vertex;
		while(!stack.isEmpty()){
			
			
			vertex = stack.pop();
			if(!print[vertex]){
				bw.write(String.valueOf(vertex) + " ");
				print[vertex] = true;
			}
			
			for(int i=1 ; i<=N ; i++){
				
				if(graph[vertex][i] && !visit[i]){
					visit[i] = true;
					stack.push(vertex);
					stack.push(i);
					break;
				}
				
			}
		}
		
	}
	
	
	
}