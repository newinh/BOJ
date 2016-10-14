import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 11023 Plus 3
 */
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		while(sc.hasNext()){
			sum += sc.nextInt();
		}
		System.out.println(sum);
		
			
	}
	
}