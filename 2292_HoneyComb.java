import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 int a = sc.nextInt();
		 
		 int bee = 1;
		 int count = 0;
		 
//		 An = 3n(n+1) + 1
		 while (a > bee ){
			 count++;
			 bee = bee + count*6;
		 }

		 System.out.println(count+1);

	}

}