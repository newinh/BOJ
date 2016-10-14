import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 10824 Four Numbers
 */
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long n1 = sc.nextInt();
		long n2 = sc.nextInt();
		long n3 = sc.nextInt();
		long n4 = sc.nextInt();
		
		String s1 = String.valueOf(n1) + String.valueOf(n2);
		String s2 = String.valueOf(n3) + String.valueOf(n4);
		
		long sum = Long.parseLong(s1);
		sum += Long.parseLong(s2);
		
		System.out.println(sum);
		
			
	}
	
}