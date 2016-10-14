import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 10822 Plus
 */
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		int sum = 0;
		while(st.hasMoreTokens())
			sum += Integer.parseInt(st.nextToken(",")) ;
		System.out.println(sum);
			
	}
	
}