import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ make one
 * using Dynamic Programming
 */
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] D = new int[N+1];
		
		for(int i = 1; i <= N ; i++){
			
			if(i == 2 || i == 3){
				D[i] = 1;
				continue;
			}
			
			D[i] = D[i-1] + 1;
			
			if( i % 2 == 0 && D[i] > D[i/2]+ 1)
				D[i] = D[i/2]+ 1;
			
			if( i % 3 == 0 && D[i] > D[i/3]+ 1)
				D[i] = D[i/3]+ 1;
		}
		
		System.out.println(D[N]);
			
	}
	
}