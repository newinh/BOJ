import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author HOON
 * @date   2016. 10. 7.
 *  Qucick Sort
 */
public class Main {
	
	/**
	 *	Quick Sort
	 *
	 * - 배열
	 * - partition
	 * - sort Method
	 * - swap
	 */
	
	private int[] data ;
	
	private Main(int n){
		data = new int[n];
	}
	
	private void swap(int[] array, int index1, int index2){
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
	
	private int partition(int[] array, int L_index, int R_index){
		
		// choose pivot!
		int P_index = L_index;
		int left = L_index+ 1;
		int right = R_index ;
		
		while(left < right){
			
			
			
			while( left <= right &&  array[left] < array[P_index] )
				left++;
			
			while( right >= left && array[right] > array[P_index])
				right--;
			
			if(left < right)
				swap(array, left, right);
			
		}
		
		if( array[P_index] >  array[right] )
		swap(array, P_index, right);
		
		return right;
	}
	
	private void quickSort(int[] array, int L_index, int R_index){
		
		if(L_index < R_index){
			int i = partition(array, L_index, R_index);
			quickSort(array, L_index, i-1);
			quickSort(array, i+1, R_index);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		PrintWriter pw = new PrintWriter(System.out);
		BufferedWriter bw = new BufferedWriter(pw);
		
		
		int n = Integer.parseInt(br.readLine());
		
		Main QS = new Main(n);
		
		for(int i=0 ; i<n ; i++){
			QS.data[i] = Integer.parseInt(br.readLine());
		}
		
		QS.quickSort(QS.data, 0, (n-1));
		
		
		for(int i=0 ; i<n ; i++){
			bw.write(String.valueOf( QS.data[i]  ));
			bw.newLine();
		}
		bw.flush();
	}

}