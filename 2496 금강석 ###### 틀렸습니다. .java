import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author HOON
 * @date   2016. 10. 15.
 * 1753 최단경로
 * using Dijkstra
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		
		Vertex[] vertices = new Vertex[V+1];
		
		for(int i = 1 ; i <= V ; i ++){
			vertices[i] = new Vertex(i);
		}
		
		vertices[start].D = 0;
			
		int[][] graph = new int [V+1][V+1];
		
		for(int i = 0 ; i < E ; i ++){
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			graph[x][y] = z;
		}
		
		boolean[] visit = new boolean[V+1];
		PriorityQueue<Vertex> PQ = new PriorityQueue<Vertex>();
		
		PQ.add(vertices[start]);
		visit[start] = true;
		
		while(!PQ.isEmpty()){
			
			int now = PQ.poll().name;
			
			
			for(int i = 1 ; i <= V ; i++){
				
				if(  graph[now][i] >0 && !visit[i] ){
					
					if ( vertices[i].D > vertices[now].D + graph[now][i])
						vertices[i].D =  vertices[now].D + graph[now][i];
					
					PQ.add(vertices[i]);
					
				}
				
			}
				
			visit[now] = true;
		}
		
		
		for(int i = 1 ; i <= V ; i ++){
			int result = vertices[i].D;
			if(result < 90000000){
				System.out.println(result);
			}else
				System.out.println("INT");
		}
		
		
	}
}

class Vertex implements Comparable<Vertex> {
	int name;
	int D;
	
	Vertex(int n){
		name = n;
		D = 987654321;
	}

	@Override
	public int compareTo(Vertex o) {
		return D < o.D ? -1 : 1 ;
	}
}

class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int value;
	
	@Override
	public int compareTo(Edge o) {
		
		return value > o.value ? 1 : -1;
	}
}
