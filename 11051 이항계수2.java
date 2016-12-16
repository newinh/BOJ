import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 12. 15.
 * BOJ 11051 이항계수2
 * DP 이용해보장
 */
public class Main {
	
	
	/*
	 *  N개중 K개를 뽑는 경우의 수는
	 *  (N-1 개중 K-1개를 뽑는 경우의 수) + (N-1 개중 K개를 뽑는 경우의 수)
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		if( K > N/2)
			K = N - K;
		int[][] D  = new int[N+1][K+2];
		
		// 초기조건
		D[1][0] = 1;
		D[1][1] = 1;
		for(int i = 1; i <= N ; i++)
			D[i][0] = 1;
		
		
		
		for(int i = 2 ; i <= N ; i++){
			
			for(int j = 1 ; j <= K && j <= N ; j++){
				D[i][j] = D[i-1][j-1] + D[i-1][j];
				
				D[i][j] %= 10007;
				
			}
		}
		
		System.out.println(D[N][K]);
			
		
		
	}
		
}
	
