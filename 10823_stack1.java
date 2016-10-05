import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 String str = "";
		 int x;
		 int count;
		 
		 int stackPoint = -1;
		 final int ERROR = -1;
		 final int MAX_STACK_SIZE = 10000;
		 
		 int [] stack = new int [MAX_STACK_SIZE];
		 
		 
		 
		 count = sc.nextInt();
		 
		 while( count != 0) {
			 count --;
			 
			 str = sc.next();
			
			 switch(str){
			 
			 case "push":
				 x = sc.nextInt();
				 stackPoint++;
				 stack[stackPoint] = x;
				 break;
				 
			 case "pop":
				 
				 if(stackPoint == -1){
					 System.out.println(ERROR);
					 break;
				 }else{
					 System.out.println(stack[stackPoint]);
					 stackPoint--;
				 }
				 break;
				 
			 case "size":
				 System.out.println(stackPoint+1);
				 break;
				 
			 case "empty":
				 if(stackPoint == -1){
					 System.out.println(1);
				 }else{
					 System.out.println(0);
				 }
				 break;
				 
			 case "top":
				 if(stackPoint == -1){
					 System.out.println(ERROR);
					 break;
				 }
				 System.out.println(stack[stackPoint]);
				 break;
			 }
		 }
		 
		 sc.close();

	}

}