import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author HOON
 * @date   2016. 10. 22.
 * BOJ 1932 숫자삼각형
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] triangle = new int[N+1][];	// 숫자삼각형!
		int[][] D = new int[N+1][];			// N까지의 합 의 => 최대값
		
		// base value
		triangle[0] = new int [2];
		D[0] = new int [2];
		
		for(int i = 1 ; i <= N ; i ++){
			st = new StringTokenizer(br.readLine(), " ");
			triangle[i] = new int[i+2];
			D[i] = new int [i+2];
			for(int j = 1 ; j <= i ; j++){
				triangle[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
			
		}
		
		
		for(int i = 1 ; i <= N ; i ++){
			for(int j = 1 ; j <= i ; j++){
				D[i][j] = Math.max(D[i-1][j-1], D[i-1][j]) + triangle[i][j] ;
			}
			
		}
		
		int result = 0;
		for(int i = 1 ; i <=N ; i ++){
			if(result < D[N][i])
				result = D[N][i];
		}
		
		System.out.println(result);
		
	}
}
