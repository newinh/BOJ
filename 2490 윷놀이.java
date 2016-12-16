import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 12. 16.
 * BOJ 2490 윷놀이
 */
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		for(int i = 0 ; i < 3 ; i++){
			
			int x = 0;
			
			for(int j = 0 ; j < 4 ; j++){
				if(sc.nextInt() == 0)
					x++;
			}
			
			switch(x){
			case 0:
				System.out.println("E");
				break;
			case 1:
				System.out.println("A");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("C");
				break;
			default:
				System.out.println("D");
			}
			
			
			
		}
	}
}
	
