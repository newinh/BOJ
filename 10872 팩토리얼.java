import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 12. 16.
 * BOJ 10872 ÆÑÅä¸®¾ó
 */
public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int x = 1;
		
		for(int i = N ; i > 0 ; i--){
			x = x*i;
		}
		System.out.println(x);
	}
		
}
	
