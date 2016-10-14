import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author HOON
 * @date   2016. 10. 13.
 * BOJ 10815 Number Card
 * using Collections
 */
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer t = new StringTokenizer(str, " ");
		int[] card1 = new int[N];
		
		int i = 0;
		while(t.hasMoreTokens()){
			card1[i] = Integer.parseInt(t.nextToken());
			i++;
		}
		Arrays.sort(card1);
		
		
		int M = Integer.parseInt(br.readLine());
		str = br.readLine();
		t = new StringTokenizer(str, " ");
		int[] card2 = new int[M];
		
		i = 0;
		while(t.hasMoreTokens()){
			card2[i] = Integer.parseInt(t.nextToken());
			i++;
		}
		
		
		for(i=0 ; i<M ; i++){
			
			if( Arrays.binarySearch(card1, card2[i]) < 0)
				bw.write("0 ");
			else
				bw.write("1 ");
				
		}
		
		bw.flush();
		
	}
	
}