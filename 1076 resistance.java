import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 1076 resistance
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		
		String r = "";
		switch(str1){
		case "black":
			break;
		case "brown":
			r = "1";
			break;
		case "red":
			r = "2";
			break;
		case "orange":
			r = "3";
			break;
		case "yellow":
			r = "4";
			break;
		case "green":
			r = "5";
			break;
		case "blue":
			r = "6";
			break;
		case "violet":
			r = "7";
			break;
		case "grey":
			r = "8";
			break;
		case "white":
			r = "9";
			break;
		}
		
		switch(str2){
		case "black":
			r += "0";
			break;
		case "brown":
			r += "1";
			break;
		case "red":
			r += "2";
			break;
		case "orange":
			r += "3";
			break;
		case "yellow":
			r += "4";
			break;
		case "green":
			r += "5";
			break;
		case "blue":
			r += "6";
			break;
		case "violet":
			r += "7";
			break;
		case "grey":
			r += "8";
			break;
		case "white":
			r += "9";
			break;
		}
		
		Long R = Long.parseLong(r);
		
		switch(str3){
		case "black":
			break;
		case "brown":
			R *= 10;
			break;
		case "red":
			R *= 100;
			break;
		case "orange":
			R *= 1000;
			break;
		case "yellow":
			R *= 10000;
			break;
		case "green":
			R *= 100000;
			break;
		case "blue":
			R *= 1000000;
			break;
		case "violet":
			R *= 10000000;
			break;
		case "grey":
			R *= 100000000;
			break;
		case "white":
			R *= 1000000000;
			break;
		}
		System.out.println(R);
	}
	
}