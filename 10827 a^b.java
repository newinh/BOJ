import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 14.
 * BOJ 10827 a^b
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));

		int b = 0;
		
		BigDecimal a = new BigDecimal(sc.next());
		b = sc.nextInt();
		
		a = a.pow(b);
		
		bw.write(a.toPlainString());
		bw.flush();
		
		
		
	}
	
}