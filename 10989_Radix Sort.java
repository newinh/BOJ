import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author HOON
 * @date   2016. 10. 6.
 * BOJ 10989 Radix Sort
 */
public class Main {
	
	private static final int DECIMAL_RADIX = 10; 
	private static final int MAXIMUM = 10000; 
	
	/**
	 *	Radix Sort
	 *
	 * 필요한 도구
	 * - 큐(Bucket)배열 (radix의 수만큼 필요하니까) (배열로 구현할 것임)
	 * - 자료가 담길 Array
	 * 
	 * 필요변수
	 * - radix (기수)
	 * - ciper (자릿수)
	 * 
	 * 필요메소드
	 * doSort
	 */
	
	private static int data[] ;
	private int cipher;
	private final int MAXIMUM_CIPHER;
	private final int RADIX;
	
	private Main(int n, int maximum, int Radix){
		
		data = new int[n];
		cipher = 1;
		RADIX = Radix;
		int i = 1;
		// find maximum ciper
		while ( ( maximum =(maximum / RADIX) ) != 0) {
			i++;
		}
		MAXIMUM_CIPHER = i;
	}
	
	private void doSort(){
		
		Queue[] bucket = new Queue[RADIX];
		for(int i=0 ; i<10 ; i++)
			bucket[i] = new Queue();
		
		for(int i = 0; i < MAXIMUM_CIPHER; i++){
			
			
			
			for(int j = 0 ; j < data.length ; j++ ){
				
				int k = (data[j] / cipher) % RADIX;
				bucket[k].enqueue(data[j]);
				
				
			}
			cipher *= RADIX;
			
			int k = 0;
			for(int j = 0 ; j < RADIX; j++){
				
				while( !bucket[j].isEmpty() ){
					data[k] = bucket[j].dequeue();
					k++;
				}
				
			}
			
		}
		
		
	}
	
	private class Queue {
		
		/**
		 *  Queue에 필요한것
		 *  - array
		 *  - 2-pointer
		 *  resizing method
		 *  enqueue method
		 *  dequeue method
		 */
		int [] queueArray ;
		int first;
		int last;
		
		private Queue(){
			queueArray = new int[8];
			first = 0;
			last = -1;
		}
		private boolean isEmpty(){
			if( last < first){
				return true;
			}
			return false;
		}
		private int getSize(){
			
			if(isEmpty())
				throw new NoSuchElementException();
			
			return last - first + 1;
		}
		
		private void enqueue(int item){
			
			last++;
			queueArray[last] = item;
			
			if( queueArray.length-1 == last ){
				int [] largeArray = new int [queueArray.length*2];
				
				for(int i = 0; i <= last-first ; i++){
					largeArray[i] = queueArray[i+first];
				}
				queueArray = largeArray;
				largeArray = null;
				last = last-first;
				first = 0;
				
			}
		}
		
		private int dequeue(){
			
			int iTmp = queueArray[first];
			first++;
			
			if( !isEmpty() && getSize() < queueArray.length/4 ){
				int[] smallArray = new int [queueArray.length/2];
				
				for(int i = 0; i <= last-first;i++){
					smallArray[i] = queueArray[i+first];
				}
				queueArray = smallArray;
				smallArray = null;
				last = last-first;
				first = 0;
			}
			return iTmp;
		}
		
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		PrintWriter pw = new PrintWriter(System.out);
		BufferedWriter bw = new BufferedWriter(pw);
		
		
		int n = Integer.parseInt(br.readLine());
		
		Main radixSort = new Main(n, MAXIMUM, DECIMAL_RADIX );
		
		for(int i=0; i<n; i++){
			radixSort.data[i] = Integer.parseInt(br.readLine());
		}
		
		radixSort.doSort();
		
		for(int i=0; i<n; i++){
			bw.write(String.valueOf(radixSort.data[i]));
			bw.newLine();
		}
		bw.flush();
		
	}

}