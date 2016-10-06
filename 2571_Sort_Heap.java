import java.io.OutputStream;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.*;
import java.io.IOException;

/**
 * @author HOON
 * @date   2016. 10. 6.
 *  Heap Sort
 */
public class Main {
	
	/**
	 * Minimum heap tree
	 * 
	 * 최소힙으로 정렬 후 루트부터 하나씩 꺼낸다!
	 * 
	 * 준비물
	 * 1. Array (인덱스 0은 사용하지 않을 예정)
	 *   
	 * 3. Insert method
	 * 4. Delete method (+ print)
	 * 
	 * 5. Get Index of (parent, left child, right child) method
	 */
	
	private int[] heap ;
	private int size;
	
	private Main(int n){
		heap = new int[n+1];
		size = 0;
	}
	
	private void insert(int a){
		size++;
		heap[size] = a;
		
		int i = size;
		
		while( i != 1 ){
			
			if( a < heap[parent(i)] ){
				swap(i, parent(i));
				i = parent(i);
			}else{
				break;
			}
		}
		
	}
	
	private int delete(){
		int tmp = heap[1];
		swap(1, size);
		size--;
		int i = 1;
		
		while( leftChild(i) <= size ){
			
			if( rightChild(i) > size || heap[leftChild(i)] < heap[rightChild(i)]){
				if(heap[leftChild(i)] < heap[i]){
					swap(i, leftChild(i));
					i = leftChild(i);
				}else{
					break;
				}
			}else{
				if(heap[rightChild(i)] < heap[i] ){
					swap(i, rightChild(i));
					i = rightChild(i);
				}else{
					break;
				}
			}
		}
		return tmp;
	}
	
	private int parent(int i){
		return i/2;
	}
	private int leftChild(int i){
		return 2*i;
	}
	private int rightChild(int i){
		return (1 + (2*i));
	}
	private void swap(int i, int j){
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
		
	
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream out = System.out;
		BufferedOutputStream bo = new BufferedOutputStream(out);
		
		PrintWriter pw = new PrintWriter(System.out);
		BufferedWriter bw = new BufferedWriter(pw);
		
		
		int n = Integer.parseInt(br.readLine());
		Main heaptree = new Main(n);
		
		
		
		for(int i = 0 ; i<n ; i++){
			heaptree.insert(Integer.parseInt(br.readLine()));
		}
		
		for(int i = 0; i < n ; i++){
			bw.write(String.valueOf(heaptree.delete()));
			bw.newLine();
		}
		bw.flush();
	}

}