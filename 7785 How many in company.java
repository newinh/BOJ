import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 7785 How many in company
 * using Collections
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		TreeSet ts = new TreeSet();
		
		String str;
		String[] strArray = new String[2];
		for(int i=0 ; i<N ; i++){
			str = br.readLine();
			strArray = str.split(" ");
			if(strArray[1].equals("enter"))
				ts.add(strArray[0]);
			else
				ts.remove(strArray[0]);
		}
		
		while(!ts.isEmpty()){
			bw.write((String)ts.pollLast());
			bw.newLine();
		}
		bw.flush();
	}
	
}