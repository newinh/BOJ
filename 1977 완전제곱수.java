import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 12. 17.
 * BOJ 1977 완전제곱수
 */
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// M <= N  <= 10000
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int count = 0;
		int sum = 0;
		int min = 0 ;
		boolean first = true;
		
		for(int i = 1 ; i < 101 ; i++){
			
			if( i*i >= M && i*i <= N){
				
				if(first){
					first = false;
					min = i*i;
				}
					
				
				count++;
				
				sum += i*i;
			}
			
		}
		
		if( count == 0)
			System.out.println("-1");
		else{
			System.out.println(sum);
			System.out.println(min);
		}
		
		
		
	}
}
	
