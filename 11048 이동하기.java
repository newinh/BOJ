import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author HOON
 * @date   2016. 10. 15.
 * BOJ 11048 이동하기
 * using dp
 */
public class Main {
	
	static int[][] D; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		D = new int[N][M];
		int[][] candy = new int[N][M];
		
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++){
				candy[i][j] = Integer.parseInt(st.nextToken());
				D[i][j] = -1;
			}
		}
		
		int result = go(N-1, M-1, candy);
		System.out.println(result);
	}
	
	
	
	
	static int go(int X, int Y, int[][] candy){
		
		if(D[X][Y] >= 0 )
			return D[X][Y];
		
		int result = 0;
		
		if( X-1 < 0 &&  Y-1 < 0){
			D[X][Y] = candy[X][Y];
			return candy[X][Y];
		}
			
		else if(X-1 < 0)
			result = go(X, Y-1, candy); 
		else if(Y-1 < 0)
			result = go(X-1, Y, candy);
		else
			result = Math.max(go(X-1, Y, candy), go(X, Y-1, candy));

		result += candy[X][Y];
		D[X][Y] = result;
		return result;
	}
	
	
	
}