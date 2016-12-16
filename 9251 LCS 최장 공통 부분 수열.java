import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 12. 16.
 * BOJ 9251 LCS 최장 공통 부분 수열
 */
public class Main {
	
	/*
	 * D[a][b]	=			 0						if a = 0 or b = 0
	 * 		  	= 			D[a-1][b-1]				if A[a] ==B[b]
	 * 			=	Max (D[a-1][b-1], D[a-1][b-1] ) else
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] A =sc.nextLine().toCharArray();
		char[] B =sc.nextLine().toCharArray();
		
		int[][] D = new int[A.length+1][B.length+1];
		
		
		for(int i = 1 ; i <= A.length ; i++){
			
			for(int j = 1 ; j <= B.length ; j++){
				
				if(A[i-1] == B[j-1])
					D[i][j] = D[i-1][j-1] + 1;
				else
					D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
				
			}
		}
		
		System.out.println(D[A.length][B.length]);
		
		
		
	}
}
	
