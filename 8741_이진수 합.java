import java.util.Scanner;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.*;
import java.io.IOException;

public class Main {
	

	public static void main(String[] args) throws IOException  {
		
		
		Scanner sc = new Scanner(System.in);
		
		OutputStream out = System.out;
		BufferedOutputStream bo = new BufferedOutputStream(out);
		
		
		int n = sc.nextInt();
		
		String s = "1";
		bo.write(s.getBytes());
		for(int i = 0; i < n-1 ; i++){
			bo.write(s.getBytes());
		}
		
		s = "0";
		
		for(int i = 1; i < n ; i++){
			bo.write(s.getBytes());
		}
		bo.flush();
		

	}

}