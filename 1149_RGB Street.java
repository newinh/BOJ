import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 1149 RGB Street
 * using Dynamic Programming
 */
public class Main {
	
	/*
	 *  D[N] = Math.min( D[N][R], D[N][G], D[N][B] )
	 *  D[N][R] = Math.min(  D[N-1][G], D[N-1][B] ) + R[N];     
	 */
	public static void main(String[] args){
		
		final int R = 0;
		final int G = 1;
		final int B = 2;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 비용
		int [] pR = new int[N];
		int [] pG = new int[N];
		int [] pB = new int[N];
		
		for(int i=0 ; i < N ; i++){
			pR[i] = sc.nextInt();
			pG[i] = sc.nextInt();
			pB[i] = sc.nextInt();
		}
		
		
		int[][] D = new int[N][3];
		
		D[0][R] = pR[0];
		D[0][G] = pG[0];
		D[0][B] = pB[0];
		
		
		for(int i =1; i<N ; i++){
			D[i][R] = Math.min(D[i-1][G], D[i-1][B]) + pR[i];
			D[i][G] = Math.min(D[i-1][R], D[i-1][B]) + pG[i];
			D[i][B] = Math.min(D[i-1][R], D[i-1][G]) + pB[i];
		}
		
		int tmp = Math.min(D[N-1][R], D[N-1][G]); 
		if( D[N-1][B] < tmp )
			tmp = D[N-1][B];
		
		System.out.println(tmp);
		
		
	}
	
}