import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 1003 Fibonacci function
 * using Dynamic Programming
 */
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		

		/*
		 *  D[N][0] : fbonacci(N)에서 0에 출력되는 갯수
		 *  D[N][1] : fbonacci(N)에서 1에 출력되는 갯수
		 *  
		 *  D[N][0] = D[N-1][0] + D[N-2][0] 
		 *  D[N][1] = D[N-1][1] + D[N-2][1]
		 */
		int[][] D = new int[41][2];
		D[0][0] = 1;
		D[1][1] = 1;
		
		
		for(int i=2 ; i<=40 ; i++){
			D[i][0] = D[i-1][0] + D[i-2][0];
			D[i][1] = D[i-1][1] + D[i-2][1] ;
		}
		
		for(int i=0 ; i < T ; i++){
			int N = sc.nextInt();
			if(N == 0){
				System.out.println("1 0");
			}else if(N == 1){
				System.out.println("0 1");
			}else {
				System.out.println(D[N][0] + " " + D[N][1]);
			}
			
		}
		
	}
	
}