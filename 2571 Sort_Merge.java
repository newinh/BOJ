import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 * @author HOON
 * @date   2016. 10. 25.
 * BOJ 2751 정렬
 * using merge sort
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		
		
		
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		for(int i = 0 ; i < N ; ++i) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		sort(array);
		
		
		for(int i = 0 ; i < N ; ++i) {
			bw.write(String.valueOf(array[i]));
			bw.newLine();
		}
		bw.flush();
		
	}
	
	
	private static void sort(int[] array){
		
		int[] tmp = new int[array.length];
		
		if( array.length <= 1)
			return;
		
		sort(array, tmp, 0, array.length-1);
		
	}
	
	private static void sort(int[] array, int[] tmp, int lo, int hi){
		
		if(lo >= hi)
			return;
		
		int mid = (lo+hi)/2;
		
		sort(array, tmp, lo, mid);
		sort(array, tmp, mid+1, hi);
		
		merge(array, tmp, lo, mid, hi);
	}
	
	private static void merge(int[] array, int[] tmp, int lo, int mid, int hi){
		
		
		for(int i = lo ; i <= hi ; i++ )
			tmp[i] = array[i];
		
		
		int i = lo;
		int j = mid+1;
		
		for(int k = lo ; k <= hi ; k++){
			
			if		(i > mid)			array[k] = tmp[j++];
			
			else if	( j > hi )			array[k] = tmp[i++];
			
			else if	(tmp[i] < tmp[j])	array[k] = tmp[i++];
			
			else						array[k] = tmp[j++];
		}
		
	}
	
}
