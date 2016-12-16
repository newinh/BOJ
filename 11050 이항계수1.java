import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 12. 15.
 * BOJ 11050 이항계수1
 */
public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		int x = factorial(N);
		x = x / factorial(K);
		x = x / factorial(N-K);
		
		
		System.out.println(x);
	}
	
	public static int factorial(int f){

		if( f == 1 || f == 0)
			return 1;
		
		return f*factorial(f-1);
	}
		
}
	
