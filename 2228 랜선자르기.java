import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 15.
 * BOJ 2228 랜선 자르기
 */
public class Main {
	
	static long testMax = 1;
	static long testMin = 0;
	static int N;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		N = sc.nextInt();
		
		int[] originals = new int[K];
		
		for(int i = 0 ; i < K ; i ++){
			originals[i] = sc.nextInt();
		}

		long test = testMax;

		boolean flag = true;
		while(true){
			
			if(test == testMin)
				break;
			int count = 0;
			
			for(int i = 0 ; i < originals.length ; i ++){
				
				count += (originals[i] / test);

				
				if(count >= N){
					
					if(flag){
						testMin = test;
						test *= 2;
						break;
						
					}
					
					testMin = test;
					test = (testMax+testMin)/2 ;
					
					break;
				}
			}
			
			if(count < N){
				if(flag)
					flag = false;
				testMax = test;
				test = (testMax+testMin)/2 ;
			}
			
			
		}
		
		
		System.out.println(testMin);
		
		
	}
	
	
}