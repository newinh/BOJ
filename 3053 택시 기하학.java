import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 12. 16.
 * BOJ 3053 택시 기하학
 */
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		
		double area = Math.pow( (double) R, 2) * Math.PI;
		double area2 = 2 * Math.pow( (double) R, 2) ;
		
		String s = String.format("%.6f", area);
		String s2 = String.format("%.6f", area2);
		System.out.println(s);
		System.out.println(s2);
		
	}
}
	
