import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 14.
 * BOJ 10757 BigNumber A+B
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);

		BigInteger A = new BigInteger(sc.next());
		BigInteger B = new BigInteger(sc.next());
		
		A = A.add(B);
		
		System.out.println(A.toString());
		String str;
		
		
	}
	
}