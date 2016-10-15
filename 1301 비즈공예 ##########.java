import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author HOON
 * @date   2016. 10. 15.
 * BOJ 1301 비즈공예
 */
public class Main {
	
	static long[][][][][][][] status = new long[11][11][11][11][11][6][6];
	static int[] beads ;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		N = sc.nextInt();
		beads = new int[6];
		for(int i=1 ; i<=N ; i++){
			beads[i] = sc.nextInt();
		}
		long cases = 0;
		
		for(int i=1 ; i<=N ; i++){
			
			for(int j=1 ; j<=N ; j++){
				
				if(i==j)
					continue;
				
				if(beads[i] == 0 || beads[j] == 0)
					continue;
				
				beads[i] -= 1;
				beads[j] -= 1;
				cases += go( beads, i, j);
				beads[i] += 1;
				beads[j] += 1;
				
			}
			
		}
		
		System.out.println(cases);
		
	}
	
	static long go( int[] beads, int pc2, int pc1){
		
		long cases = status[beads[1]][beads[2]][beads[3]][beads[4]][beads[5]][pc2][pc1];
		
		if(cases != 0)
			return cases;

		int a = 0;
		for(int i=1; i<=N; i++){
			a += beads[i]; 
		}
		if(a == 0)
			return 1;
		
		for(int i=1; i<=N; i++){
			
			if(beads[i]==0)
				continue;
			if( i == pc2 || i == pc1)
				continue;
			
			beads[i]-= 1;
			cases += go(beads, i, pc2 );
			beads[i]+= 1;
		}
		
		
		return cases;
	}
	
}