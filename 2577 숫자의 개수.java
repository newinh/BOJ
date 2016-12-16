import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 12. 16.
 * 2577 숫자의 개수
 */
public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt()*sc.nextInt()*sc.nextInt();
		
		char[] c = String.valueOf(A).toCharArray();
		int[] result = new int[10];
		
		for(int i = 0 ; i < c.length ; i++)
			result[ c[i]-'0' ] ++;
		
		
		for(int i = 0 ; i < result.length ; i++)
			System.out.println(result[i]);
		
			
		
	}
}
	
