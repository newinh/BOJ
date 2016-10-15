import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author HOON
 * @date   2016. 10. 15.
 * BOJ 11403 경로찾기
 */
public class Main {
	
	static int[][] D; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int[][] D = new int[N][N];
		for(int i=0 ; i<N ; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0 ; j<N ; j++){
				D[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0 ; k < N ; k++){
			for(int i = 0 ; i < N ; i ++){
				for(int j = 0 ; j < N ; j ++){
					
					if( D[i][k] == 1 && D[k][j] == 1 )
						D[i][j] = 1;
					
				}
				
			}
		}
		
		
		for(int i=0 ; i<N ; i++){
			for(int j=0 ; j<N ; j++){
				bw.write(D[i][j] + " " );
			}
			bw.newLine();
		}
		
		
		bw.flush();
		
	}
	
	
	
	
	
}