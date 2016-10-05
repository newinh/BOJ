import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 int x = sc.nextInt();
		 
		 int bee = 1;
		 int count = 1;
		 int a;
		 int b;
		 
		 while (x > bee ){
			 count++;
			 bee = bee + count;
		 }
		 
		 if(count % 2 == 0) {

			 bee -= x; 
			 
			 a = count - bee;
			 b = bee + 1;
			 
		 } else{
			 
			 bee -= x;
			 
			 a = bee + 1;
			 b = count - bee;
		 }
		 
		 
		 System.out.println(a + "/" + b);
		 sc.close();

	}

}