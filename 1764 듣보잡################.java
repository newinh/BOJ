import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 10828 Stack
 * using Collections
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		Stack stack = new Stack();
		
		int N = sc.nextInt();
		
		for(int i=0 ; i<N ; i++){
			
			switch( sc.next() ){
			
			case "push":
				stack.push(sc.nextInt());
				break;
				
			case "pop":
				
				if(stack.empty()){
					bw.write("-1");
				}else{
					bw.write(String.valueOf(stack.pop()));
				}
				bw.newLine();
				break;
				
			case "size":
				bw.write(String.valueOf(stack.size()));
				bw.newLine();
				break;
				
			case "empty":
				if(stack.empty())
					bw.write("1");
				else
					bw.write("0");
				bw.newLine();
				break;
				
			case "top":
				if(stack.empty()){
					bw.write("-1");
				}else{
					bw.write(String.valueOf(stack.peek()));
				}
				bw.newLine();
				break;
			
			}
		}
		
		bw.flush();
	}
	
}