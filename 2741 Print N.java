import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 2741 Print N
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		int N = sc.nextInt();
			
		
		for(int i=1 ; i <= N ; i++){
			bw.write(String.valueOf(i));
			bw.newLine();
		}
		bw.flush();
	}
	
}