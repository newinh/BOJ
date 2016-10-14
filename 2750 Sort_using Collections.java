import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 2750 Sort
 * using Collection
 */
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List l = new ArrayList(N);
		
		for(int i=0 ; i<N ; i++){
			l.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(l);
		
		Iterator it = l.iterator();
		while(it.hasNext()){
			bw.write(String.valueOf(it.next()));
			bw.newLine();
		}
		
		bw.flush();
		
	}
	
}