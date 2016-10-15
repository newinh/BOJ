import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 15.
 * BOJ 1922 네트워크 연결
 * using MST
 */
public class Main {
	
	static Vertex[] vertices;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		 vertices = new Vertex[N+1];
		for(int i = 1 ; i <= N ; i ++){
			vertices[i] = new Vertex(i, i);
		}
		
		
		int M = sc.nextInt();
		Edge[] edges = new Edge[M];
		
		for(int i = 0 ; i < M ; i++){
			
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int value = sc.nextInt();
			
			edges[i] = new Edge(v1, v2, value);
		}
		
		Arrays.sort(edges);
		
		HashSet<Edge> MST = new HashSet<Edge>();
		
		for(int i = 0 ; i < M ; i++){
			
			int v1 = edges[i].v1;
			int v2 = edges[i].v2;
			
			int a = findRootName (vertices[v1]) ;
			int b = findRootName (vertices[v2]) ;
			
			// 사이클 아님
			if (  a != b){
				
				vertices[v1].set = b;
				
				MST.add(edges[i]);
				
				if(MST.size() >= N-1)
					break;
			}
		}
		
		long sum = 0;
		Iterator<Edge> it = MST.iterator();
		while(it.hasNext()){
			Edge newEdge = it.next();
//			System.out.println(newEdge.v1 + " - " + newEdge.v2);
			sum += newEdge.value;
		}
			
		System.out.println(sum);
		

		
	}
	static int findRootName(Vertex v){
		
		while( v.name != v.set )
			v = vertices[v.set];
		
		return v.name;
	}
	
}


class Vertex{
	int name;
	int set;
	int length = 1;
	Vertex(int N, int S){
		name = N;
		set = S;
	}
}



class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int value;
	
	Edge(int v1, int v2, int value){
		this.v1 = v1;
		this.v2 = v2;
		this.value = value;
	}
	
	@Override
	public int compareTo(Edge o) {
		if(this.value < o.value)
			return -1;
		else if(this.value > o.value)
			return 1;
		return 0;
	}
}