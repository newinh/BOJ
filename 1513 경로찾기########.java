import java.io.IOException;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 15.
 * BOJ 1513 경로찾기
 */
public class Main {
	
	static final int MOD = 1000007;
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int C = sc.nextInt();
		
		int[][][][] D = new int[N+1][M+1][C+1][C+1];
		int[][] spot = new int [N+1][M+1];
		
		for(int i = 0 ; i < N+1 ; i++){
			for(int j = 0 ; j < N+1 ; j++){
				spot[i][j] = -1;
			}
		}
		
		for(int i=0 ; i<C ; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			spot[x][y] = i; 
		}
		D[1][0][0][0] = 1;
		
		
		for(int i = 1 ; i <= N ; i++){
			for(int j = 1 ; j <= M ; j++){
				
				if(spot[i][j] == -1){
					D[i][j][0][0] += D[i-1][j][0][0] + D[i][j-1][0][0];
					D[i][j][0][0] %= MOD;
				}
				
				for(int l=1; l<=C ; l++){
					if(spot[i][j] == -1){
						
						for(int k = 0 ; k< C ; k++){
							D[i][j][k][l] += D[i-1][j][k][l] + D[i][j-1][k][l];
							D[i][j][k][l] %= MOD;
						}
						
						
					}else{
						int top = spot[i][j];
						
						
						if(l == 1){
							D[i][j][top][l] += D[i-1][j][0][0] + D[i][j-1][0][0];
							D[i][j][top][l] %= MOD;
						}else{
							for(int k = 0 ; k < top ; k++){
								D[i][j][top][l] += D[i-1][j][k][l-1] + D[i][j-1][k][l-1];
								D[i][j][top][l] %= MOD;
							}
						}
					}
				}
				
			}
		}
		
		for(int l =0 ; l <= C ; l++){
			
			int result = 0;
			
			for(int k = 0 ; k <Math.max(C, 1) ; k++){
				result += D[N][M][k][l] ;
				result %= MOD;
			}
			System.out.print(result + " ");
		}
		
	}
}